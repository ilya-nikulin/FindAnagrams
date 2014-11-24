package ru.simpls.findanagrams;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MainActivity extends ActionBarActivity {
    private EditText sourceFile;
    private EditText outFile;
    private ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button selectSource = (Button) findViewById(R.id.selectSource);
        sourceFile = (EditText) findViewById(R.id.sourceFile);
        selectSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonChooseFile(v, sourceFile);
            }
        });
        pBar=(ProgressBar)findViewById(R.id.progressBar);
        Button selectOut = (Button) findViewById(R.id.selectOut);
        outFile = (EditText) findViewById(R.id.outFile);
        selectOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonChooseFolder(v, outFile);
            }
        });
        Button find = (Button) findViewById(R.id.findAnograms);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonFind();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    ////////////////////////////////
    public void onButtonChooseFile(View v, final EditText editFile) {

        //Create FileOpenDialog and register a callback
        SimpleFileDialog fileOpenDialog =  new SimpleFileDialog(
                MainActivity.this,
                "FileChoose",
                new SimpleFileDialog.SimpleFileDialogListener()
                {
                    @Override
                    public void onChosenDir(String chosenDir)
                    {
                        // The code in this function will be executed when the dialog OK button is pushed
                        editFile.setText(chosenDir);
                    }
                }
        );
        //You can change the default filename using the public variable "Default_File_Name"
        fileOpenDialog.default_file_name = editFile.getText().toString();
        fileOpenDialog.chooseFile_or_Dir(fileOpenDialog.default_file_name);
    }
    ////////////////////////
    public void onButtonChooseFolder(View v, final EditText editFile) {

        //Create FileOpenDialog and register a callback
        SimpleFileDialog fileOpenDialog =  new SimpleFileDialog(
                MainActivity.this,
                "FolderChoose",
                new SimpleFileDialog.SimpleFileDialogListener()
                {
                    @Override
                    public void onChosenDir(String chosenDir)
                    {
                        // The code in this function will be executed when the dialog OK button is pushed
                        editFile.setText(chosenDir);
                    }
                }
        );
        //You can change the default filename using the public variable "Default_File_Name"
        fileOpenDialog.default_file_name = editFile.getText().toString();
        fileOpenDialog.chooseFile_or_Dir(fileOpenDialog.default_file_name);
    }
    ////////////////////////////
    public void onButtonFind(){
        pBar.setVisibility(View.VISIBLE);
        Result result = new Result();
        int step = 100;
        int startPos=0;
        int startLine = 0;result.getLines().size();
        while(true) {
            startLine = result.getLines().size();
            if (!readInput(result, startPos, step, startLine)){
                break;
            }
            result.deleteExtraWords();
            startPos+=step;
        }
        result.deleteExtraWords();
        if (writeResult(result)){
            Toast.makeText(this, "completed successfully", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "failed", Toast.LENGTH_LONG).show();
        }
        pBar.setVisibility(View.INVISIBLE);
    }
    ///////////////////
    public Boolean writeResult(Result result){
        String fileName = outFile.getText().toString();
        if (fileName.length()<1){
            Toast.makeText(this, "out folder not selected", Toast.LENGTH_LONG).show();
            return false;
        }
        File file = new File(fileName, "result.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            result.write(bw);
            bw.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
            return false;
        }
        return true;
    }
    /////////////////////
    public boolean readInput(Result result, int startPos, int step, int startLine){

        String fileName = sourceFile.getText().toString();
        if (fileName.length()<1){
            Toast.makeText(this, "source file not selected", Toast.LENGTH_LONG).show();
            return false;
        }
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Scanner scanner = new Scanner(br);
            scanner.useDelimiter("\\,|\\.");
            int i=-1;
            while (scanner.hasNext())
            {
                i++;
                String word = scanner.next().trim();
                if (startPos>i){
                continue;
            }
                if (i<(startPos+step)){
                    result.processWord(word, true, startLine);
                }
                else{
                    result.processWord(word, false, startLine);
                }
            }
            if (i<(startPos+step)){
                return false;
            }
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
            return false;
        }
        return true;
    }
}

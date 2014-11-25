FindAnagrams
============
The following test implies no additional explanations. In case of any questions or
misunderstanding, Keep It Simple should be followed.
Introduction
The goal of the test is to check the practical experience with Java language in particular and
computer science in general.
During implementation of the test you can use:
● Oracle Java Development Kit 6/7 and its documentation
● Android SDK and its documentation
● any 3-rd party open source Java/Android libraries
● IntelliJ IDEA, Android Studio
● Preferable build system is Gradle
Estimated time of implementation — 1 hour.

Task description
The task is to develop an application, which determine all anagrammatic combinations in
input file. An anagram is a type of word play, the result of rearranging the letters of a word to
produce a new word, using all the original letters exactly once; for example orchestra can be
rearranged into carthorse.
For example:
node ~ done
stop ~ pots ~ spot
pool ~ loop ~ polo

Input format
● application should accept absolute or relative path
○ of the file which contains arbitrary text where anagrammatic combinations
should be found
○ of the file where all anagrammatic combinations should be printed
● file where anagrammatic combinations should be found contains unformatted text
(txt file) in UTF-8 encoding
● size of the input file is between 1B and 100MB

Output format
● the application execution should result in a file, which contains list of anagrammatic
combinations, found in input file
● each anagrammatic combination should be printed separately like in the file (see
example)
● combinations should be printed to output file in the order they appear in input file.
Examples of both input and output files are provided in Appendix A.

Deliverables
Results of the test should be packed into ZIP-archive, which contains:
● source code in located src directory
● APK-file, which can be executed on device
● any 3rd party libraries used for the test

Additional test
The implementation of unit tests for the application will give additional value to your test task.
Appendix A
Example of input file

========= START OF THE FILE =========
come, get, give, go, keep, let, make, put, seem, take, be, do, have, say, see, send, may, will,
about, across, after, against, among, at, before, between, by, down, from, in, off, on, over,
through, to, under, up, with, as, for, of, till, than, a, the, all, any, every, no, other, some, such,
that, this, I, he, you, who, and, but, or, if, though, while, how, when, where, why, again, ever,
far, forward, here, near, now, out, still, then, there, together, well, almost, enough, even, little,
much, not, only, quite, so, very, south, east, west, please, yes.
account, act, art, attack, attempt, attention, attraction, authority, back, balance, base,
behaviour, belief, birth, bit, bite, blood, blow, burn, burst, business, butter, canvas, care, cause,
chalk, chance, change, cloth, coal, colour, comfort, cook, copper, copy, cork, cotton, cough,
country, cover, crack, credit, crime, crush, cry, current, curve, damage, danger, daughter,
day, death, debt, decision, degree, design, desire, destruction, detail, development, digestion,
direction, discovery, discussion, disease, disgust, distance, distribution, division, doubt, drink,
driving, dust, earth, edge, education, effect, end, error, event, example, fact, fall, family,
father, fear, feeling, fiction, field, fight, fire, flame, flight, flower, fold, food, force, form, grain,
grass, grip, group, growth, guide, harbour, harmony, hate, hearing, heat, help.
page, pain, paint, paper, part, paste, payment, peace, person, place, plant, play, pleasure,
point, poison, polish, porter, position, powder, power, price, print, process, produce, profit,
property, prose, protest, pull, push, quality, question, rain, range, rate, ray, reaction, request,
respect, rest, reward, rhythm, rice, river, road, roll, room, rub, rule, run, salt, sand, scale,
science, sea, seat, secretary, selection, self, sense, servant, sex, shade, shake, shame, shock,
side, sign, silk, sky, sleep, slip, slope, smash, smell, smile, smoke, sneeze, snow, soap, society,
son, song, sort, sound, soup, space, stage, start, statement, steam, steel, step, stitch, stone,
stop, story, stretch, swim, system, talk, taste, tax, teaching, tendency, test, theory, thing,
thought, thunder, time, tin, top, touch, trade, transport, trick, trouble, turn, twist, unit, use,
value, verse, vessel, view, voice, walk, war, wash, waste, water, wave, wax, way, weather,
week, weight, wind, wine, winter, woman, wood, wool, word, work, wound, writing, year.
angle, ant, apple, arch, arm, army, baby, bag, ball, band, basin, basket, bath, bed, bee, bell,
berry, bird, blade, board, boat, bone, book, boot, bottle, box, boy, brain, brake, branch, brick,
bridge, brush, bucket, bulb, button, cake, camera, card, cart, carriage, cat, chain, cheese,
chest, chin, church, circle, clock, cloud, coat, collar, comb, cord, cow, cup, curtain, cushion,
dog, door, drain, drawer, dress, drop, ear, egg, engine, eye, face, farm, feather, finger, fish,
flag, floor, fly, foot, fork, fowl, frame, garden, girl, glove, goat, gun, hair, hammer, hand, hat,
head, heart, hook, horn, horse, house, island, jewel, kettle, key, knee, knife, knot, leaf, leg,
library, line, lip, lock, map, match, moon, mouth, muscle, nail, neck, needle, nerve, net, nose,
nut, office, orange, oven, parcel, pen, pencil, picture, pig, pin, pipe, plane, plate, plough,
pocket, pot, potato, prison, pump, rail, rat, receipt, ring, rod, roof, root, sail, school, scissors,
screw, seed, sheep, shelf, ship, shirt, shoe, skin, skirt, snake, sock, spade, sponge, spoon, spring,
square, stamp, star, station, stem, stick, stocking, stomach, store, street, sun, table, tail,
thread, throat, thumb, ticket, toe, tongue, tooth, town, train, tray, tree, trousers, umbrella,
wall, watch, wheel, whip, whistle, window, wing, wire, worm.
able, acid, early, elastic, electric, equal, fat, fertile, first, fixed, flat, free, full, general, good,
great, grey, hanging, happy, hard, healthy, high, hollow, important, kind, like, living, long,
male, married, material, medical, military, natural, new, normal, open, parallel, past, poor,
possible, present, private, probable, quick, quiet, ready, red, regular, responsible, right, round,
same, sticky, stiff, straight, strong, sudden, sweet, tall, thick, tight, tired, true, violent, waiting,
warm, wet, wide, wise, yellow, young.
awake, bad, bent, bitter, blue, certain, cold, complete, cruel, dark, dead, dear, delicate,
different, dirty, dry, false, feeble, female, foolish, future, green, ill, last, late, left, loose, loud,
low, mixed, old, opposite, public, rough, sad, safe, secret, short, shut, simple, slow, small, soft,
solid, special, strange, thin, white, wrong.
========== END OF THE FILE ==========

Example of output file
========= START OF THE FILE =========
from, form
on, no
who, how
quite, quiet
east, seat
act, cat
art, rat
danger, garden
earth, heart
hate, heat
reward, drawer
salt, last
top, pot
========== END OF THE FILE ==========

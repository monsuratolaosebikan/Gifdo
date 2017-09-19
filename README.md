Gifdo
=====

Gifdo is an open source todo app with a twist - gifs. It makes your todo list more fun to look at and do!

![DEMO](https://user-images.githubusercontent.com/11881456/30509407-0e8f0362-9a7e-11e7-9f5a-0649625b5c78.gif)
![DEMO_2](https://user-images.githubusercontent.com/11881456/30509484-c4a22610-9a7f-11e7-9817-dd2b48b2cd6e.gif)
![DEMO_3](https://user-images.githubusercontent.com/11881456/30509537-d356d024-9a80-11e7-9aba-6689d768571e.gif)

Overview
---------
This app was built for Tufts University COMP 150 - Mobile Development class taught by Ming Chow in Fall 2017. The purpose of this project was to familiarize ourselves with Android development by creating a small app of our choosing individually before jumping into our semester long project in teams.

## Usage Instructions
### Creating a new todo
Press the pink fab button with the plus sign and you will be taken to a new screen where you can enter the text
of the todo. Once entered you can close your keyboard and press the fab with a check mark to add the todo to the main list and your new todo will 
be displayed at the top of the list with a gif representation*.

*correct representation of todo is not guaranteed

### Deleting a todo
Long press a todo and it will be automatically deleted. *Warning*: there is no undo so use good judgement :) 

## How to Run
1. git clone this repository
2. open project in android studio
3. press the run button in android studio to build and compile to run in simulator or real device 

## Resources
- [Giphy API](https://developers.giphy.com/) - for getting awesome gifs based on a search term
- [Glide](http://bumptech.github.io/glide/) - used to display gifs in an imageview which isn't natively supported
- [Stetho](http://facebook.github.io/stetho/) - is a debug bridge that I used for looking at my SQLite database through chrome dev tools 
- [Android Docs](https://developer.android.com/guide/index.html) - Activities, Fragments, CardView, RecyclerView, SQLite3
- Tutorials on CardView/Recycler View:
  - [Tutsplus](https://code.tutsplus.com/tutorials/getting-started-with-recyclerview-and-cardview-on-android--cms-23465)
  - [Sitepoint 1](https://www.sitepoint.com/starting-android-development-creating-todo-app/)
  - [Android Tutorials Point](https://www.androidtutorialpoint.com/material-design/android-cardview-tutorial/)
- [Screen Recording](http://www.androidauthority.com/android-customization-screen-recording-adb-599331/) - how to make a screen recording using adb shell

## What I learned
Completing this project gave me a crash course in android development. I learned how to start activities and fragments, use recycler and card views, make an HTTP request, read and write to the built in sqlite database, and add external libraries to my project. And finally, I learned the pitfals of layouts not showing up as you want them to and how to fix some common issues.

## License
MIT License

Copyright (c) 2017 Monsurat Olaosebikan

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

![Amuyaña](http://i65.tinypic.com/e69ht4.jpg)

(Last update: 21/02/2017)

## Introduction
Amuyaña is an Application that generates and designs **Tables of deductions** (*ToD*). The word *amuyaña* is a term in Aymara.

A *ToD* is an abstract representation of a dynamism's evolution in the terms of the logic of the contradictory which is a formal logical system developed by french-romanian philosopher Stéphane Lupasco in the 1950's. His logic remains until today unknown to the vast majority of sciences, so this application also aims at spreading acknowledgement and recognition of Lupasco's work.

The main purpose of this Application is to serve as a tool for organizing information in a scientific investigation that applies the logic of the contradictory.

In [this wiki-style site](https://sites.google.com/site/ayarportugal/logica-dinamica-de-lo-contradictorio)  you'll find more information about the logic of the contradictory and the Tables of deduction.

The [project's website](https://sites.google.com/site/ayarportugal/amuyana/) contains some simple tutorials which illustrate the use of Amuyaña.

The [github wiki](https://github.com/CREAR-ASBL/amuyana/wiki) has information about the  structure of the (java) source code.

These pages will be updated continually so visit them from time to time.

## Current version
1.3

## How to install
There is no installer for Amuyaña, instead you jut download an executable file, open it and start using the application.

This file is OS independent, it should work in any system (Linux, Windows or Mac) that has the latest Java Runtime Environement installed. If you have any problem please contact us.

Download it [here](https://sites.google.com/site/ayarportugal/amuyana/descargar).

## How to use
Simply put, once you start the application you start creating the *branches* of the *ToD* in two steps: first defining *contradictional disjunctions*, their corresponding *contradictional conjunctions* and *contradictory phenomena*, and then you visualize or export (as an image) the *ToD*.

## Instructions for developpers
Amuyaña has been written in Java. We maintain only a master branch.

The simplest way to get the source code is to pull the repository, for example:

	git clone https://github.com/CREAR-ASBL/amuyana.git

Once you have the repository you will notice that it can be oppened as a NetBeans project.

- Don't remove the .gitignore file, however you can safely remove three files: &#95;config.yml, README and LICENCE.

- The file build.xml contains instructions to package the source code into the executable jar, including the gson library (otherwise the default executable jar obtained after the compilation requires the gson.jar library). In NetBeans execute build.xml by right clicking build.xml in the 'files' tab (Menu &rarr; Window &rarr; Files) and selecting 'Run Target &rarr; Other Targets &rarr; package_for_store'

Before compiling or building the project through build.xml you need to add Gson (used to save the ToD in the disk until we find another solution that does not require an external library) to the project's library. You can download ([here](https://github.com/google/gson/)) that library, to import it in netbeans, right click in "Libraries" in the Projects tab (Menu &rarr; Window &rarr; Projects), click on "Add JAR/Folder" and then select *gson-2.8.0.jar*. Gson is released under the Apache 2.0 license.

## To-do

The development plan is in the [wiki section](https://github.com/CREAR-ASBL/amuyana/wiki/Planification).

## Licence

Amuyaña is distributed under the  General Public Licence version 3.

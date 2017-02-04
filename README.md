![Chuyma](https://github.com/CREAR-ASBL/amuya-a/blob/master/logo.v.2.png)

(Last update: 05/02/2017)

## Introduction
Amuyaña is an Application that generates ** *Tables of deductions* ** (*ToD*).

A *ToD* is an abstract representation of a dynamism's evolution in the terms of the logic of the contradictory which is a formal logical system developped by french-romanian philosopher Stéphane Lupasco in the 1950's. His logic remains until today unknown to the vast majority of sciences, so this application aims at spreading acknowledgement and recognition of Lupasco's work.

The purpose of this Application is to serve as a tool for organizing information in any scientific investigation, for example we (the *Collectif de Recherche Et d'Action pour la Réciprocité* - Belgium) expect to use this app, once it's fully mature, in the context of social research, in particular in the context of a *system of reciprocity*.

The word *amuyaña* is a concept in Aymara, it roughly means "understanding", however this concept refers mostly to the kind of understanding that one acquires with the practice.

## How to install
There is no installer for Amuyaña, instead you jut download an executable file and open it and start using the application.

This file should normally execute in any platform (Linux, Windows or Mac) that has the latest Java Runtime Environement installed. If you have any problem please contact us.

You can download the latest version (v.1.1) [here](https://github.com/CREAR-ASBL/amuyana/blob/master/releases/v.1.1/store/Amuya%C3%B1a.jar).

## How to use
Simply put, once you start the application you start creating the *branches* of the *ToD* in two steps: first defining *contradictional disjunctions*, their corresponding *contradictional conjunctions* and *contradictory phenomena*, and then you visualize or export (as an image) the *ToD*.

To know more about the logic of the contradictory, the *ToD* and the other notions of this logic, visit my personal [site](https://sites.google.com/site/ayarportugal/).

## Instructions for developpers
Amuyaña has been written in Java. We maintain only two branches: master and dev.
	
The simplest way to get the source code is to pull the repository, for example:

	git clone https://github.com/CREAR-ASBL/amuyana.git

We maintain two branches:

- *master* branch has the source files of the stable releases.
- *dev* branch has of course the source files under developpement but these can be oppened easily with Netbeans since it is a Netbeans project. However to run the program you'll need one dependency.

You can read about the internal structure of the -java- application in our github [wiki](https://github.com/CREAR-ASBL/amuyana/wiki).

### Dependencies

There is only one dependency: Gson, which is a library to convert Java Objects into their JSON representation and vice-versa. You need to download ([here](https://github.com/google/gson/)) that library first and import it. In netbeans I right-clicked in "Libraries" in the Projects tab (Menu &rarr; Window &rarr; Projects), clicked on "Add JAR/Folder" and then selected *gson-2.8.0.jar*.

## Roadmap

(Not in chronological order)

- Implement distinct visualizations of the ToD:
	- ~~Lupasco style~~ (done): The way Stéphane Lupasco represented the ToD himself in his book about the logic of the contradictory (*"Le principe d'antagonisme et la logique de l'énergie"*).
	- Sierpinski style: Our representation of the ToD using the *Sierpinski's fractal*.
	- Chakana style: Our representation of the ToD using the "Andean cross".
	- Amuyaña style: Our representation of the ToD using circular representations.
- Handle time series data, in particular for the fields of the A.class, P.class and T.class classes which are the main focus of attention for a scientific analysis.
- Implement distint versions of Amuyaña: amuyaña-agenda, amuyaña-economy, amuyaña-production, amuyaña-research, ...
- Implement a javaFX-based GUI so that it can be "embeded" in a website.

## Licence

Amuyaña is distributed under the  General Public Licence version 3.
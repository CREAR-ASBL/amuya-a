![Amuyaña](http://i65.tinypic.com/e69ht4.jpg)

(Last update: 21/02/2017)



## Introduction
Amuyaña is an Application under development that will create visual representations of Systems with the formal logic axioms of the Dynamic Logic of the Contradictory. The word *amuyaña* is a term in Aymara that means "thinking", "reasoning" or "understanding".

It has two main purposes: Generate visual representations of the main concepts of the Logic of the Contradictory and maintain the statistical data and its analysis.

You can download the latest version here (v1.3). However the current development version (v.2) differs significantly from that release, which is why the repository has been whiped out and only contains a development branch for the future v.2 release.

If you're interested on this software you can learn how it works in the [wiki section](https://github.com/CREAR-ASBL/amuyana/wiki).

## History
The development of this software parallels the progression of my understanding of the Logic of the Contradictory.

The first version (called Chuyma) would only recreate the *transfinite* development of new branches of the Table of Deductions, because at that time (2016) I thought the ToD was the central concept for describing a Contradictional logic system (it is, not just the only one).

After testing that first release and trying to create logic systems, I realized that the code (written in Python) was not good enough to do what I was expecting (to print in the screen the same figures I draw by hand). That is why I started using Java (first Java Swing and later JavaFX) and renamed the software Amuyaña. One of my main concerns was the relation between the statistics (from the theory to its empirical implementation) and the definition of new elements of the CLS. Later I would get to the conclusion that if one wants to create a visual representation -as detailed as possible but also as simple as it can be-, there are actually three concepts which need to be defined:

- Table of Deductions:
- Tridialectic Apparatus:
- Space-Time Configuration:

And the statistical data is directly linked to each one of these three concepts.

It is worth mentioning that these three concepts, which I claim are sufficient to create a detailed representation of a CLS, are deduced, summarized, from one and only one concept, which plays the role of hypothesis, axiom or postulate, called by Lupasco the Fundamental Postulate of the Dynamic Logic of the Contradictory. This fundamental Postulate invites the thinker, the one who wants to apply this formal logic, to consider not two (True or False) but three possible eventualities (Positive, Negative or Symmetric) at the moment of "sorting out" the categories in its mind (and later in Amuyaña or eventually a piece of paper). Explaining what does this exactly mean is beyond the scope of this document (visit the [website](http://amuyaña.com/) for more information), but the point is that the *Fundamental Postulate*, which describes how and why these three eventualities can happen and actually do happen, is sufficient to deduce the ToD, TA and the STC. In other words, we are not interpreting the Logic of the Contradictory, we are fully recreating its main core concepts by departing from only the Fundamental Postulate.

Starting from the release v2 the structure of the source code changes completely. I privilege the emulation of a formation of a fundamental duality (two elements becoming associated as in the Fundamental Postulate) and then the graphical engine inmediately creates a visual representation, in contrast to the previous version where statistical data introduced (the first step of the "emulation") was a separate task from the creation of the visual representations. This was the case because I wanted to save the raw data (the files with the extension .ña which contained the elements of the system), and separating data from graphical representation seemed logical to me. Unfortunately this is not the best option when there are more than one representation needed, like when we introduce the Tridialectic Apparatus and the Space-Time Configuration (at first I thought the ToD was first, then the other two, but actually the three are equally important), and at the end I decided to start from scratch.

Amuyaña has the final objective of serving as a tool for organizing information in scientific investigations, specially when the Logic of the Contradictory is required.

## Current version
1.3

## Development version
2

## Instructions for developpers
Amuyaña has been written in Java and JavaFX.

The simplest way to get the source code is to pull the repository, for example:

	git clone https://github.com/CREAR-ASBL/amuyana.git

Open the repository with NetBeans or enter to the source folder to access the code.

Visit the [wiki section](https://github.com/CREAR-ASBL/amuyana/wiki) for more information about the source code and how it runs step by step to create the main graphs. A more detailed overview of the classes, methods, variables, etc. is available in the docs.

## Links

The [project's website](http://amuyaña.com).

The [github wiki](https://github.com/CREAR-ASBL/amuyana/wiki) has information about the  structure of the (java) source code.

## Abbreviations
Contradictional Logic System or logic system of the Dynamic Logic of the Contradictory = CLS
Table of Deductions = ToD

## Licence

Amuyaña is distributed under the  General Public Licence version 3.

= Profile-based approach
:experimental:

== General process

The idea behing this approach is that there will be some benefits
in the use of the {uml} standard. Hence the DSL will be based on {UML}
by using the profile mechanisms.

As illustrated in <<Selic07-fig,this figure>>, here is the processus
we can follow:

. Starting from the expected DSL and a description of the domain model
. A domain model is more precisely defined (e.g. a class diagram)
. The concepts (e.g., `Task` in <<Selic07-fig,this figure>>) are mapped to the
more suitable UML elements (e.g., `Class` in <<Selic07-fig,this figure>>)
. If the concepts directly match UML concepts (or if there is a way to slightly modify
  them so that they match) then it is possible to define a profile.
. Else another solution (e.g., defining a metamodel from scratch) should be studied.

[NOTE]
====
There are different ways of defining the domain model:

- the domain expert provides the domain model (e.g., UML class diagram)
- the UML expert translate the concepts from the stakeholders into a domain
model
- the UML expert and the domain expert build a model as close as possible
of the expected DSL and the UML expert extract the core concepts in a domain
model
====

== Iterative process

The above process is iterative. The constructs are introduced by step.
The profile is experimented in a model importing the profile so that the user can validate
that the concepts are captured adequatly.
This is were the UML expert can use tuning possibilities.

== Improvements

The next steps consist in:

* defining a dedicated diagrams
* providing a wizard for the new language
* defining a specific property view (menu:File[New ... Property View Configuration]
  and then right click on the generated property)
* Working on the concrete syntax:
** customizing the styles
** customizing menu:New[Child]
** customizing the Model explorer
** packaging together the profile, the property view, the palette, etc.

[TIP]
=====

- Papyrus provides a _DSML Configuration plugin_ to help on these steps.
- There is also the possibility of defining a _Feature_ that group together
a set of profiles
=====




The profile is defined:

- in terms of stereotypes (extending metaclasses)
- adding specific properties to the stereotype (e.g., `period` in <<Selic07-fig,this figure>>)
- adding OCL constraints

NOTE: Using `ecore`, the process consists in startin from scratch, from an empty
metamodel. The domain model is then define "by construction".
In the `UML profile` approach we start with an existing (complete) metamodel
and the profiling activity consist in restricting it to specific elements.
In this approach the assumption is that their is a benefit in having both
additional concepts and tooling, notably in terms of *extensibility* mecanisms
and *scalability*.

== Example of work on the concrete syntax

Let us illustrate the need for a specific concrete syntax.

NOTE: cf tuto pour "New Table (cf. yupanqui)"

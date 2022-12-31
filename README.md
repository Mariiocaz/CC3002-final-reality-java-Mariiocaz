Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

Weapons
--------
All weapons have the same behavior. The existing types of weapons are:

**-Sword**

**-Axe**

**-Knife**

**-Staff**

**-Bow**

***code logic:***

The "GameWeapon" interface has the signature of the methods: getWeaponName, getDamage,
getWeight, getType, equippedByEngineer, equippedByKnight, equippedByThief,
equippedByWhiteMage and equippedByBlackMage.

The abstract class "Weapon" implements the methods mentioned above except getType and EquippedBy...
which will be abstract methods.

The classes for each weapon hang from the Weapon abstract class and implement hashCode;
toString; equals; EquippedBy...; getType (For getType, the elements of WeaponType are used
only to give the type name, but not to designate the weapon).

Characters
--------
Each character has a name, a class,
health and defense points. You must also be able to add yourself to the queue and wait your turn.

***code logic:***

The "GameCharacter" interface has the signature of the methods: waitTurn, addToQueue,
getName, getMaxHP, getCurrentHP, setCurrentHP and getDefense.

The abstract class "AbstractCharacter" implements the methods mentioned above except waitTurn and addToQueue,
which will be an abstract method.

Player´s Characters
--------
Player-occupied characters can be grouped into two categories, common characters and wizards.
The common characters are those who cannot use magic, in particular they are composed of:

**-Knight**

**-Engineer**

**-Thief**

On the other hand, mages have an additional attribute that we will call MP. The types are:

**-White Mage**

**-Black Mage**

Each character can wield some types of weapons, The types of weapons that each class can 
equip are shown below:

**-Knight ->** Sword ; Axe ; Knife

**-Engineer ->** Axe ; Bow

**-Thief ->** Sword ; Knife ; Bow

**-White Mage ->** Staff

**-Black Mage ->** Staff ; Knife

***code logic:***

The "PlayerCharacter" interface extends from "GameCharacter" and has the signature of the methods:
Equip and getEquippedWeapon.

The abstract class "AbstractPlayerCharacter" extends "AbstractCharacter" and implements the methods
getEquippedWeapon, waitTurn and addToQueue.

"AbstractPlayerCommonCharacter" is an abstract class that extends from "AbstractPlayerCharacter" and
is used to gather the common characters.

The common characters classes extend directly "AbstractPlayerCommonCharacter" and implement to
equip, hashcode, toString and equals methods.

The "PlayerMagicCharacter" interface extends from "GameCharacter" and has the signature of the methods:
getMaxMP, getCurrentMP and setCurrentMP.

The abstract class "AbstractPlayerMagicCharacter" extends "AbstractPlayerCharacter" and 
implements the methods mentioned in MagicCharacter.

The magic characters classes extend directly "AbstractPlayerMagicCharacter" and implement to
equip, hashcode, toString and equals methods.


--------
**Code logic when equipping a weapon**

So that a character can equip a weapon that corresponds to his class, we use double dispatch
to know if the weapon is equippable and if the answer is positive equip it, otherwise give an
exception.

Through the Equip method found in each class of each character, the character asks the weapon he
is equipping if it can be occupied by calling the equippedBy... method of the weapon he is trying to equip,
if the weapon can be equipped, he replies yes, and it is equipped, otherwise it throws an exception
(InvalidEquippableWeapon).

--------


Enemies
--------
In the fights, in addition to the characters that the player will control, there will be one or
more enemies. every enemy It will have a name, life points, defense, attack and weight. 
Enemies cannot equip items.

***code logic:***

The "GameEnemy" interface extends from "GameCharacter" and has the signature of the methods:
getWeight and getDamage.

The Enemy class directly extends "AbstractCharacter" and implements the
methods in GameEnemy, also the waitTurn and addToQueue methods that come from AbstractCharacter.

Spells
--------
In addition to their weapons, mages can use spells with different effects.

**Thunder** (15 MP): Reduces the opponent's life by magicDamage to the enemy and has a 30% chance
to paralyze him.

**Fire** (15 MP): Reduces the opponent's life by magicDamage to the enemy and has a 20% chance
to burn it.

**Heal** (15 MP): Heals an ally for 30% of their maximum HP.

**Poison** (40 MP): Poisons an enemy.

**Paralysis** (25 MP): Paralyzes an enemy.

Adverse effects
--------
In the game there will be three types of adverse effects, these effects are caused by the effect of a spell used
by the player. The effects are:

**Paralysis**

**Poisoned**

**Burned**

UML Diagrams
--------

**Game Character UML:**

[![Game-Character-UML.png](https://i.postimg.cc/ZnKYMP5V/Game-Character-UML.png)](https://postimg.cc/LYwMq1f1)

**Game Weapon UML:**

[![Game-Weapon-UML.png](https://i.postimg.cc/bYBjPfCz/Game-Weapon-UML.png)](https://postimg.cc/vDfK7kwj)

**Spells UML:**

[![Spells-UML.png](https://i.postimg.cc/QM0yqcvX/Spells-UML.png)](https://postimg.cc/5HQg4QxG)

**State (Adverse effects) UML:**

[![StateUML.png](https://i.postimg.cc/x1q5SBZS/StateUML.png)](https://postimg.cc/PCsYWVh6)

Instructions
--------
You can try this project using Java 18.

In order to test the "tests", you can execute the folder test in:

**final-reality-java-Mariiocaz/src**


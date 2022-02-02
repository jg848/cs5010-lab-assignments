package dungeon;

/**
 * Builder class implemented to construct a {@link Level} in a game that is set
 * in medieval fantasy. Also responsible to check the consistency of the details
 * in the game.
 * 
 * @author Jaswin Gumpella
 *
 */
public class MedievalLevelBuilder {

  private int levelNumber;
  private int numberOfRooms;
  private int numberOfMonsters;
  private int numberOfTreasures;
  private Level level;
  private int availableRooms;
  private int availableMonsters;
  private int availableTreasures;

  /**
   * Default constructor for the level builder class which takes the inputs of
   * level number, number of rooms, number of monsters and number of treasures.
   * 
   * @param levelNo       which is a numeric representing the level number of the
   *                      game.
   * @param noOfRooms     which is a numeric representing the number of rooms in a
   *                      {@link Level}.
   * @param noOfMonsters  which is a numeric representing the number of monsters
   *                      in a {@link Level}.
   * @param noOfTreasures which is a numeric representing the number of treasures
   *                      in a {@link Level}.
   */
  public MedievalLevelBuilder(int levelNo, int noOfRooms, int noOfMonsters, int noOfTreasures) {
    level(levelNo);
    rooms(noOfRooms);
    monsters(noOfMonsters);
    treasures(noOfTreasures);
    level = new Level(this.levelNumber);
  }

  /**
   * Helper method used to set the level number for the game.
   * 
   * @param level which is a numeric representing the level number of the game.
   * @throws IllegalArgumentException if level number is zero or negative.
   */
  private void level(int level) {
    if (level <= 0) {
      throw new IllegalArgumentException("Level of the game should be greater than 0.");
    } else {
      this.levelNumber = level;
    }
  }

  /**
   * Helper method used to set the number of rooms a level can have.
   * 
   * @param rooms which is a numeric representing the number of rooms in a
   *              {@link Level}.
   * @throws IllegalArgumentException if number of rooms is negative.
   */
  private void rooms(int rooms) {
    if (rooms < 0) {
      throw new IllegalArgumentException("Number of rooms for the level should be non negative.");
    } else {
      this.numberOfRooms = rooms;
      this.availableRooms = this.numberOfRooms;
    }
  }

  /**
   * Helper method used to set the number of monsters a {@link Level} can have.
   * 
   * @param monsters which is a numeric representing the number of monsters in a
   *                 {@link Level}.
   * @throws IllegalArgumentException if number of monsters is negative.
   */
  private void monsters(int monsters) {
    if (monsters < 0) {
      throw new IllegalArgumentException(
          "Number of monsters for the level should be non negative.");
    } else {
      this.numberOfMonsters = monsters;
      this.availableMonsters = this.numberOfMonsters;
    }
  }

  /**
   * Helper method used to set the number of treasures a level can have.
   * 
   * @param treasures which is a numeric representing the number of treasures in a
   *                  {@link Level}.
   * @throws IllegalArgumentException if number of treasures is negative.
   */
  private void treasures(int treasures) {
    if (treasures < 0) {
      throw new IllegalArgumentException(
          "Number of treasures for the level should be non negative.");
    } else {
      this.numberOfTreasures = treasures;
      this.availableTreasures = this.numberOfTreasures;
    }
  }

  /**
   * Method used to add a room in the level with the given room description.
   * 
   * @param roomDescription which represents the description of the room to be
   *                        added.
   * @return instance of the {@link MedievalLevelBuilder} class if a {@link Room}
   *         is added successfully into the {@link Level}, throws an
   *         {@link IllegalStateException} if the room limit has been reached.
   * @throws IllegalStateException if target number of rooms reached.
   */
  public MedievalLevelBuilder addRoom(String roomDescription) {
    if (this.availableRooms > 0) {
      level.addRoom(roomDescription);
      this.availableRooms--;
    } else {
      throw new IllegalStateException(
          "Room cannot be added to the level as it already contains the maximum number of rooms.");
    }
    return this;
  }

  /**
   * Helper method for adding a {@link Monster} into a given room.
   * 
   * @param roomNumber which is the room number of a {@link Level} to add the
   *                   {@link Monster}.
   * @param monster    which is the {@link Monster} to be added into a room.
   * @throws IllegalStateException    if the target room with roomNumber is not
   *                                  created.
   * @throws IllegalStateException    if the target number of monsters for the
   *                                  level is reached.
   * @throws IllegalArgumentException if room number to add the monster is
   *                                  invalid.
   */
  private void addMonster(int roomNumber, Monster monster) {

    if (roomNumber >= 0 && roomNumber < this.numberOfRooms) {
      if (roomNumber < (this.numberOfRooms - this.availableRooms)) {
        if (this.availableMonsters > 0) {
          level.addMonster(roomNumber, monster);
          this.availableMonsters--;
        } else {
          throw new IllegalStateException("Target number of Monsters for the level reached.");
        }
      } else {
        throw new IllegalStateException("Target room not created.");
      }
    } else {
      throw new IllegalArgumentException("Room number to add the monster is invalid.");
    }
  }

  /**
   * Method used to add the {@link Monster} 'Goblin' into a specified room in the
   * level.
   * 
   * @param roomNumber      which is the room number in which the {@link Monster}
   *                        is to be added.
   * @param numberOfGoblins which is the number of monsters that are to be added
   *                        into the {@link Room}.
   * @return instance of {@link MedievalLevelBuilder} with the {@link Monster}
   *         added into a {@link Room} of the {@link Level}.
   * @throws IllegalArgumentException if the numberOfGoblins to be added is less
   *                                  than or equal to 0.
   */
  public MedievalLevelBuilder addGoblins(int roomNumber, int numberOfGoblins) {

    if (numberOfGoblins > 0) {
      Monster goblin = new Monster("goblin", "mischievous and very unpleasant, vengeful, "
          + "and greedy creature whose primary purpose is to cause trouble to humankind", 7);
      for (int i = 0; i < numberOfGoblins; i++) {
        this.addMonster(roomNumber, goblin);
      }
    } else {
      throw new IllegalArgumentException("Invalid number of goblins input.");
    }
    return this;
  }

  /**
   * Method used to add the {@link Monster} 'Orc' into a specified room in the
   * level.
   * 
   * @param roomNumber which is the room number in which the {@link Monster} is to
   *                   be added.
   * @return instance of {@link MedievalLevelBuilder} with the {@link Monster}
   *         added into a {@link Room} of the {@link Level}.
   */
  public MedievalLevelBuilder addOrc(int roomNumber) {
    Monster orc = new Monster("orc", "brutish, aggressive, malevolent being serving evil", 20);
    this.addMonster(roomNumber, orc);
    return this;
  }

  /**
   * Method used to add the {@link Monster} 'Ogre' into a specified room in the
   * level.
   * 
   * @param roomNumber which is the room number in which the {@link Monster} is to
   *                   be added.
   * @return instance of {@link MedievalLevelBuilder} with the {@link Monster}
   *         added into a {@link Room} of the {@link Level}.
   */
  public MedievalLevelBuilder addOgre(int roomNumber) {
    Monster ogre = new Monster("ogre",
        "large, hideous man-like being that likes to eat humans for lunch", 50);
    this.addMonster(roomNumber, ogre);
    return this;
  }

  /**
   * Method used to add the {@link Monster} 'Human' into a specified room in the
   * level.
   * 
   * @param roomNumber  which is the room number in which the {@link Monster} is
   *                    to be added.
   * @param name        which represents the name of the Human to be added into a
   *                    {@link Room}.
   * @param description which represents the details of the Human to be added into
   *                    a {@link Room}.
   * @param value       which represents the value of the Human to be added into a
   *                    {@link Room}.
   * @return instance of {@link MedievalLevelBuilder} with the {@link Monster}
   *         added into a {@link Room} of the {@link Level}.
   * @throws IllegalArgumentException if the details of the human are invalid.
   */
  public MedievalLevelBuilder addHuman(int roomNumber, String name, String description, int value) {
    if (null != name && !name.isBlank() && null != description && !description.isBlank()
        && value >= 0) {
      Monster ogre = new Monster(name, description, value);
      this.addMonster(roomNumber, ogre);
    } else {
      throw new IllegalArgumentException("Details of the human should not be empty.");
    }
    return this;
  }

  /**
   * Helper method for adding a {@link Treasure} into a given room.
   * 
   * @param roomNumber which is the room number of a {@link Level} to add the
   *                   {@link Treasure}.
   * @param treasure   which is the {@link Treasure} to be added into a room.
   * @throws IllegalStateException    if the target room with roomNumber is not
   *                                  created.
   * @throws IllegalStateException    if the target number of treasures for the
   *                                  level is reached.
   * @throws IllegalArgumentException if room number to add the treasure is
   *                                  invalid.
   */
  private void addTreasure(int roomNumber, Treasure treasure) {

    if (roomNumber >= 0 && roomNumber < this.numberOfRooms) {
      if (roomNumber < (this.numberOfRooms - this.availableRooms)) {
        if (this.availableTreasures > 0) {
          level.addTreasure(roomNumber, treasure);
          this.availableTreasures--;
        } else {
          throw new IllegalStateException("Target number of Treasures for the level reached.");
        }
      } else {
        throw new IllegalStateException("Target room not created.");
      }
    } else {
      throw new IllegalArgumentException("Room number to add the treasure is invalid.");
    }
  }

  /**
   * Method used to add the {@link Treasure} 'Potion' into a specified room in the
   * level.
   * 
   * @param roomNumber which is the room number in which the {@link Treasure} is
   *                   to be added.
   * @return instance of {@link MedievalLevelBuilder} with the {@link Treasure}
   *         added into a {@link Room} of the {@link Level}.
   */
  public MedievalLevelBuilder addPotion(int roomNumber) {
    Treasure treasure = new Treasure("a healing potion", 1);
    this.addTreasure(roomNumber, treasure);
    return this;
  }

  /**
   * Method used to add the {@link Treasure} 'Gold' into a specified room in the
   * level.
   * 
   * @param roomNumber which is the room number in which the {@link Treasure} is
   *                   to be added.
   * @param value      which is a numeric value of gold.
   * @return instance of {@link MedievalLevelBuilder} with the {@link Treasure}
   *         added into a {@link Room} of the {@link Level}.
   * @throws IllegalArgumentException if the value of gold is less than or equal
   *                                  to 0.
   */
  public MedievalLevelBuilder addGold(int roomNumber, int value) {
    if (value > 0) {
      Treasure treasure = new Treasure("pieces of gold", value);
      this.addTreasure(roomNumber, treasure);
    } else {
      throw new IllegalArgumentException("Value of gold to add the treasure is invalid.");
    }
    return this;
  }

  /**
   * Method used to add the {@link Treasure} 'Weapon' into a specified room in the
   * level.
   * 
   * @param roomNumber which is the room number in which the {@link Treasure} is
   *                   to be added.
   * @param weapon     which is a Weapon description.
   * @return instance of {@link MedievalLevelBuilder} with the {@link Treasure}
   *         added into a {@link Room} of the {@link Level}.
   * @throws IllegalArgumentException if the description of the weapon is empty.
   */
  public MedievalLevelBuilder addWeapon(int roomNumber, String weapon) {
    if (!weapon.isBlank()) {
      Treasure treasure = new Treasure(weapon, 10);
      this.addTreasure(roomNumber, treasure);
    } else {
      throw new IllegalArgumentException("Weapon description to add the treasure is invalid.");
    }
    return this;
  }

  /**
   * Method used to add the {@link Treasure} 'Special' into a specified room in
   * the level.
   * 
   * @param roomNumber which is the room number in which the {@link Treasure} is
   *                   to be added.
   * @param special    which is a Special treaure description.
   * @param value      which is the numeric representing the value of the
   *                   {@link Treasure}.
   * @return instance of {@link MedievalLevelBuilder} with the {@link Treasure}
   *         added into a {@link Room} of the {@link Level}.
   * @throws IllegalArgumentException if the description of the special treasure
   *                                  is empty.
   * @throws IllegalArgumentException if the value of the special treasure is less
   *                                  than or equal to 0.
   */
  public MedievalLevelBuilder addSpecial(int roomNumber, String special, int value) {
    if (!special.isBlank()) {
      if (value > 0) {
        Treasure treasure = new Treasure(special, value);
        this.addTreasure(roomNumber, treasure);
      } else {
        throw new IllegalArgumentException("Value of Special treasure is invalid.");
      }
    } else {
      throw new IllegalArgumentException("Special description to add the treasure is invalid.");
    }
    return this;
  }

  /**
   * Build method for the Level class which checks if all the required features
   * have been added to the {@link Level}.
   * 
   * @return an instance of the {@link Level} class which has all the features
   *         added.
   * @throws IllegalStateException if rooms, monsters or treasures are not
   *                               completely added according to the given numbers
   *                               at the time of constructing the
   *                               {@link MedievalLevelBuilder} object.
   */
  public Level build() {
    if (this.availableRooms == 0 && this.availableMonsters == 0 && this.availableTreasures == 0) {
      return this.level;
    } else {
      throw new IllegalStateException(
          "Level build failed. Rooms, Monsters or Treasures not added completely.");
    }
  }
}

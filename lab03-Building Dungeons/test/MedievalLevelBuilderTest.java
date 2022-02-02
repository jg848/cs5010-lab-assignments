import static org.junit.Assert.assertEquals;

import dungeon.Level;
import dungeon.MedievalLevelBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the builder class {@link MedievalLevelBuilder} which is used
 * to test the {@link Level} construction.
 * 
 * @author Jaswin Gumpella
 *
 */
public class MedievalLevelBuilderTest {

  MedievalLevelBuilder builder;

  /**
   * Method used to setup the builder class for testing.
   * 
   * @throws IllegalArgumentException when illegal arguments are passed.
   */
  @Before
  public void setUp() throws IllegalArgumentException {
    builder = new MedievalLevelBuilder(1, 3, 10, 10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#MedievalLevelBuilder(int, int, int, int)}
   * with success case values.
   */
  @Test
  public final void testMedievalLevelBuilder() {
    builder = new MedievalLevelBuilder(1, 3, 10, 10);
    assertEquals(MedievalLevelBuilder.class, builder.getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#MedievalLevelBuilder(int, int, int, int)}
   * with negative level number.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMedievalLevelBuilderInvalidLevelNumber() {
    new MedievalLevelBuilder(-1, 3, 10, 10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#MedievalLevelBuilder(int, int, int, int)}
   * with level number as 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMedievalLevelBuilderZeroLevelNumber() {
    new MedievalLevelBuilder(0, 3, 10, 10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#MedievalLevelBuilder(int, int, int, int)}
   * with negative number of rooms value.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMedievalLevelBuilderInvalidNumberOfRooms() {
    new MedievalLevelBuilder(1, -3, 10, 10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#MedievalLevelBuilder(int, int, int, int)}
   * with number of rooms as 0.
   */
  @Test
  public final void testMedievalLevelBuilderZeroNumberOfRooms() {
    builder = new MedievalLevelBuilder(1, 0, 10, 10);
    assertEquals(MedievalLevelBuilder.class, builder.getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#MedievalLevelBuilder(int, int, int, int)}
   * with negative number of monsters value.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMedievalLevelBuilderInvalidNumberOfMonsters() {
    new MedievalLevelBuilder(1, 3, -10, 10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#MedievalLevelBuilder(int, int, int, int)}
   * with number of monsters as 0.
   */
  @Test
  public final void testMedievalLevelBuilderZeroNumberOfMonsters() {
    builder = new MedievalLevelBuilder(1, 3, 0, 10);
    assertEquals(MedievalLevelBuilder.class, builder.getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#MedievalLevelBuilder(int, int, int, int)}
   * with negative number of treasures value.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testMedievalLevelBuilderInvalidNumberOfTreasures() {
    new MedievalLevelBuilder(1, 3, 10, -10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#MedievalLevelBuilder(int, int, int, int)}
   * with number of treasures as 0.
   */
  @Test
  public final void testMedievalLevelBuilderZeroNumberOfTreasures() {
    builder = new MedievalLevelBuilder(1, 3, 10, 0);
    assertEquals(MedievalLevelBuilder.class, builder.getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)}.
   */
  @Test
  public final void testAddRoom() {
    assertEquals(MedievalLevelBuilder.class, builder.addRoom("Room 0").getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding too
   * many rooms.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddRoomTooManyRooms() {
    builder.addRoom("Room 0").addRoom("Room 2").addRoom("Room 3").addRoom("Room 4");
  }

  /**
   * Test method for {@link dungeon.MedievalLevelBuilder#addGoblins(int, int)}.
   */
  @Test
  public final void testAddGoblins() {
    builder.addRoom("Room 0").addGoblins(0, 10);
    assertEquals(MedievalLevelBuilder.class, builder.getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding too
   * many goblins.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddTooManyMonsters() {
    builder.addRoom("Room 0").addGoblins(0, 20);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding goblins
   * with invalid number of goblins.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddGoblinsInvalidNumberOfGoblins() {
    builder.addRoom("Room 0").addGoblins(0, -20);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding goblins
   * into a room which is not created.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddGoblinsRoomNotCreated() {
    builder.addRoom("Room 0").addGoblins(1, 20);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding goblins
   * with invalid number.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddGoblinsInvalidRoomNumber() {
    builder.addRoom("Room 0").addGoblins(-2, 10);
  }

  /**
   * Test method for {@link dungeon.MedievalLevelBuilder#addOrc(int)}.
   */
  @Test
  public final void testAddOrc() {
    assertEquals(MedievalLevelBuilder.class, builder.addRoom("Room 0").addOrc(0).getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding orcs
   * with invalid number.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddOrcInvalidRoomNumber() {
    builder.addRoom("Room 0").addOrc(-2);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding orcs to
   * a room which is not created.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddOrcIntoRoomNotCreated() {
    builder.addRoom("Room 0").addOrc(2);
  }

  /**
   * Test method for {@link dungeon.MedievalLevelBuilder#addOgre(int)}.
   */
  @Test
  public final void testAddOgre() {
    assertEquals(MedievalLevelBuilder.class, builder.addRoom("Room 0").addOgre(0).getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding ogre
   * with invalid number.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddOgreInvalidRoomNumber() {
    builder.addRoom("Room 0").addOgre(-2);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding ogre to
   * a room which is not created.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddOgreIntoRoomNotCreated() {
    builder.addRoom("Room 0").addOgre(2);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addHuman(int, java.lang.String)}.
   */
  @Test
  public final void testAddHuman() {
    assertEquals(MedievalLevelBuilder.class,
        builder.addRoom("Room 0").addHuman(0, "John", "Chef", 10).getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Human
   * with invalid number.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddHumanInvalidRoomNumber() {
    builder.addRoom("Room 0").addHuman(-2, "John", "Chef", 10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Human
   * to a room which is not created.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddHumanIntoRoomNotCreated() {
    builder.addRoom("Room 0").addHuman(2, "John", "Chef", 10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Human
   * with invalid name.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddHumanInvalidName() {
    builder.addRoom("Room 0").addHuman(0, "", "Chef", -10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Human
   * with invalid description.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddHumanInvalidDescription() {
    builder.addRoom("Room 0").addHuman(0, "John", "", -10);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Human
   * with invalid value.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddHumanInvalidValue() {
    builder.addRoom("Room 0").addHuman(0, "John", "Chef", -10);
  }

  /**
   * Test method for {@link dungeon.MedievalLevelBuilder#addPotion(int)}.
   */
  @Test
  public final void testAddPotion() {
    assertEquals(MedievalLevelBuilder.class, builder.addRoom("Room 0").addPotion(0).getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding too
   * many Potions.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddTooManyPotion() {
    builder.addRoom("Room 0").addPotion(0).addPotion(0).addPotion(0).addPotion(0).addPotion(0)
        .addPotion(0).addPotion(0).addPotion(0).addPotion(0).addPotion(0).addPotion(0).addPotion(0)
        .addPotion(0);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Potion
   * with invalid number.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddPotionInvalidRoomNumber() {
    builder.addRoom("Room 0").addPotion(-1);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Potion
   * to a room which is not created.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddPotionIntoRoomNotCreated() {
    builder.addRoom("Room 0").addPotion(1);
  }

  /**
   * Test method for {@link dungeon.MedievalLevelBuilder#addGold(int, int)}.
   */
  @Test
  public final void testAddGold() {
    assertEquals(MedievalLevelBuilder.class, builder.addRoom("Room 0").addGold(0, 100).getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Gold
   * with invalid number.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddGoldInvalidRoomNumber() {
    builder.addRoom("Room 0").addGold(-1, 100);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Gold to
   * a room which is not created.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddGoldIntoRoomNotCreated() {
    builder.addRoom("Room 0").addGold(1, 100);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Gold
   * with invalid value.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddGoldInvalidValue() {
    builder.addRoom("Room 0").addGold(0, -100);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addWeapon(int, java.lang.String)}.
   */
  @Test
  public final void testAddWeapon() {
    assertEquals(MedievalLevelBuilder.class,
        builder.addRoom("Room 0").addWeapon(0, "Gun").getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Weapon
   * with invalid number.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddWeaponInvalidRoomNumber() {
    builder.addRoom("Room 0").addWeapon(-1, "Gun");
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Weapon
   * to a room which is not created.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddWeaponIntoRoomNotCreated() {
    builder.addRoom("Room 0").addWeapon(1, "Gun");
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Weapon
   * with invalid description.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddWeaponInvalidDescription() {
    builder.addRoom("Room 0").addWeapon(0, "");
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addSpecial(int, java.lang.String, int)}.
   */
  @Test
  public final void testAddSpecial() {
    assertEquals(MedievalLevelBuilder.class,
        builder.addRoom("Room 0").addSpecial(0, "Painting", 1000).getClass());
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Special
   * treasure with invalid number.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddSpecialInvalidRoomNumber() {
    builder.addRoom("Room 0").addSpecial(-1, "Painting", 1000);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Special
   * treasure to a room which is not created.
   */
  @Test(expected = IllegalStateException.class)
  public final void testAddSpecialIntoRoomNotCreated() {
    builder.addRoom("Room 0").addSpecial(1, "Painting", 100);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Special
   * treasure with invalid description.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddSpecialInvalidDescription() {
    builder.addRoom("Room 0").addSpecial(0, "", 1000);
  }

  /**
   * Test method for
   * {@link dungeon.MedievalLevelBuilder#addRoom(java.lang.String)} adding Special
   * treasure with invalid value.
   */
  @Test(expected = IllegalArgumentException.class)
  public final void testAddSpecialInvalidValue() {
    builder.addRoom("Room 0").addSpecial(0, "Painting", -1000);
  }

  /**
   * Test method for {@link dungeon.MedievalLevelBuilder#build()}.
   */
  @Test
  public final void testBuild() {
    builder.addRoom("Room 0").addRoom("Room 1").addRoom("Room 2");
    builder.addGoblins(0, 6);
    builder.addOrc(1);
    builder.addOgre(1);
    builder.addHuman(2, "John", "Chef", 10).addHuman(2, "Jack", "Police", 30);
    builder.addPotion(2).addPotion(2).addPotion(2).addPotion(2).addPotion(2);
    builder.addGold(0, 100).addGold(0, 100);
    builder.addWeapon(1, "Gun").addWeapon(1, "Gun");
    builder.addSpecial(1, "Painting", 1000);
    assertEquals(Level.class, builder.build().getClass());
  }

  /**
   * Test method for {@link dungeon.MedievalLevelBuilder#build()}.
   */
  @Test(expected = IllegalStateException.class)
  public final void testBuildFail() {
    builder.addRoom("Room 0").addRoom("Room 1").addRoom("Room 2");
    builder.addGoblins(0, 6);
    builder.addOrc(1);
    builder.addOgre(1);
    builder.addHuman(2, "John", "Chef", 10).addHuman(2, "Jack", "Police", 30);
    builder.addPotion(2).addPotion(2).addPotion(2).addPotion(2).addPotion(2);
    builder.addGold(0, 100).addGold(0, 100);
    builder.addWeapon(1, "Gun").addWeapon(1, "Gun");
    builder.build();
  }

}

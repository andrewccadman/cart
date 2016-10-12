package cart

/**
 * Created by andrewcadman on 11/10/2016.
 */

trait Item  {

  def cost: Double
}

trait Fruit extends Item { }

class Apple extends Fruit {

  def cost: Double = 0.60
}

class Orange extends Fruit {

  def cost: Double = 0.25
}

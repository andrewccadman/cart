package cart

/**
 * Created by andrewcadman on 11/10/2016.
 */
trait Cart {

  var shoppingList: List[Item]

  def add(item: Item): Unit

  def getShoppingList: List[Item]

  def checkout: Double

  def wipeList: Unit

}

object ConcreteCart extends Cart {

  var shoppingList: List[Item] = List[Item]()

  def add(item: Item): Unit = { shoppingList = item :: shoppingList }

  def getShoppingList: List[Item] = shoppingList

  def checkout: Double = shoppingList.map(_.cost).sum

  def wipeList: Unit = {shoppingList = List[Item]() }
}

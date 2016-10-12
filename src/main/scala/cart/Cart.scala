package cart

/**
 * Created by andrewcadman on 11/10/2016.
 */
trait Cart {

  var shoppingList: List[Item]

  var allSpecialOffers: List[SpecialOffers]

  def add(item: Item): Unit

  def addSpecialOffer(offer: SpecialOffers): Unit

  def getShoppingList: List[Item]

  def checkout: Double

  def wipeList: Unit

}

object ConcreteCart extends Cart {

  var shoppingList: List[Item] = List[Item]()

  var allSpecialOffers: List[SpecialOffers] = List[SpecialOffers]()

  def add(item: Item): Unit = { shoppingList = item :: shoppingList }

  def addSpecialOffer(offer: SpecialOffers): Unit  = allSpecialOffers = offer :: allSpecialOffers

  def getShoppingList: List[Item] = shoppingList

  def checkout: Double = shoppingList.map(_.cost).sum

  def wipeList: Unit = {shoppingList = List[Item]() }
}

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

  def wipeAll: Unit

}

object ConcreteCart extends Cart {

  var shoppingList: List[Item] = List[Item]()

  var allSpecialOffers: List[SpecialOffers] = List[SpecialOffers]()

  def add(item: Item): Unit = { shoppingList = item :: shoppingList }

  def addSpecialOffer(offer: SpecialOffers): Unit  = allSpecialOffers = offer :: allSpecialOffers

  def getShoppingList: List[Item] = shoppingList

  def checkout: Double = {

    val checkoutSum: Double = allSpecialOffers.isEmpty match {
      case true => shoppingList.map(_.cost).sum
      case false => {
        var sum: Double = 0
        for (specOffer <- allSpecialOffers) {
          var myOfferCounter = 0
          var offerSum: Double = 0
          for (item <- shoppingList) {
            if (specOffer.item.getClass == item.getClass) {
              myOfferCounter += 1
              offerSum += item.cost
              if (myOfferCounter == specOffer.Quantity) {
                sum += offerSum / myOfferCounter * specOffer.PriceMultiple
                myOfferCounter = 0
                offerSum = 0
              }
            }
          }
          sum += offerSum
          shoppingList = shoppingList.filter(_.getClass != specOffer.item.getClass)
        }
        val remainder: Double = shoppingList.map(_.cost).sum
        sum += remainder
        sum
      }
    }

    checkoutSum
  }

  def wipeAll: Unit = {
    shoppingList = List[Item]()
    allSpecialOffers = List[SpecialOffers]()

  }
}

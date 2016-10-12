package cart

/**
 * Created by andrewcadman on 11/10/2016.
 */

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfterEach
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestCart extends FunSuite with BeforeAndAfterEach {

  test("adding an item"){
    ConcreteCart.add(new Apple())
    val shoppingList: List[Item] = ConcreteCart.getShoppingList
    assert(shoppingList.size == 1)
    assert(shoppingList.head.isInstanceOf[Apple])
  }

  test("cost of items in cart") {

      ConcreteCart.add(new Apple())
      ConcreteCart.add(new Apple())
      ConcreteCart.add(new Orange())

      assert(ConcreteCart.checkout == 1.45)

  }

  test("cost of items in cart with special offer of buy 1 get one free apple")  {

    val specOffer = SpecialOffers(new Apple,2,1)
    ConcreteCart.addSpecialOffer(specOffer)
    ConcreteCart.add(new Apple())
    ConcreteCart.add(new Apple())
    ConcreteCart.add(new Orange())

    assert(ConcreteCart.checkout == 0.85)
  }

  test("cost of items in cart with special offer of buy 3 oranges for price of 2")  {

    val specOffer = SpecialOffers(new Orange,3,2)
    ConcreteCart.addSpecialOffer(specOffer)
    ConcreteCart.add(new Apple())
    ConcreteCart.add(new Apple())
    ConcreteCart.add(new Orange())
    ConcreteCart.add(new Orange())
    ConcreteCart.add(new Orange())

    assert(ConcreteCart.checkout == 1.70)
  }

  test("cost of items in cart with special offers on Apples and Oranges")  {

    ConcreteCart.addSpecialOffer(SpecialOffers(new Orange,3,2))
    ConcreteCart.addSpecialOffer(SpecialOffers(new Apple,2,1))
    ConcreteCart.add(new Apple())
    ConcreteCart.add(new Apple())
    ConcreteCart.add(new Orange())
    ConcreteCart.add(new Orange())
    ConcreteCart.add(new Orange())

    assert(ConcreteCart.checkout == 1.10)
  }

  override def afterEach() {
    ConcreteCart.wipeAll
  }

}

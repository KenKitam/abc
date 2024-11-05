//:load amm/amm/pizza/栄養献立d.sc
object RangeModel:
  opaque type Va = Option[Int]
  object Va:
    def apply(v: Int): Va =
      if Range(0, 200).exists(_ == v) then Some(v) else None
  extension (v: Va) def va: Option[Int] = v

  opaque type Vb = Option[Double]
  object Vb:
    def apply(v: String): Vb =
      if v.matches("[1-2]??[0-9]??[0-9].[0-9][0-9]??") then Some(v.toDouble)
      else None
  extension (v: Vb) def vb: Option[Double] = v

import RangeModel.*

enum Three_meals:
  case Breakfast, Lunch, Dinner, Snack
enum Meal_composition:
  case Staple_food, Soup, Side_dish, Main_dish, Milk_Dairy_products, Fruit,
    Mid_meal
enum Gender:
  case Male, Female
enum AHW:
  case Age(x: Va)
  case Height(x: Vb)
  case Weight(x: Vb)
enum Exercise:
  case Light, Normal, Heavy
enum Food_type:
  case Regular_meal, Diabetic_food, Kidney_disease_food, Heart_disease_food,
    Low_salt_food

import Three_meals.*, Meal_composition.*, Gender.*, AHW.*, Exercise.*,
  Food_type.*
import java.time.LocalDate
case class Body_attribute(
    sx: Gender,
    age: Age,
    hgt: Height,
    wgt: Weight,
    ld: Exercise
)
case class Menu(
    dy: LocalDate,
    f3: Three_meals,
    bA: Body_attribute,
    fC: Seq[Meal_composition],
    fk: Food_type
)
val myKon = Menu(
  LocalDate.now,
  Breakfast,
  Body_attribute(
    Male,
    Age(Va(29)),
    Height(Vb("172.9")),
    Weight(Vb("50.3")),
    Normal
  ),
  Seq(Staple_food, Soup),
  Regular_meal
)
println(myKon)


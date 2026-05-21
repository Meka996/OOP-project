package oopProject;

public class Diet implements Trackable{
	private int menuChoice;
	private int dtGoal;
	private int dtIntensity;
	private double waterIntake;
	private GeneralUser gu;

	public Diet( GeneralUser gu   ,  double waterIntake, int dtGoal, int dtIntensity) {
		this.gu=gu;
		this.waterIntake = waterIntake;
		this.dtGoal = dtGoal;
		this.dtIntensity = dtIntensity;
	}
	
	public String waterInfo() {
		double optimal = gu.getWeight() * 0.033;  

		double difference = optimal - waterIntake;

		if (waterIntake <= 0.5) {
			return ("Severe dehydration!"+ "You need at least " + String.format("%.2f", optimal) + " liters daily.");
		}
		else if (difference > 1) {
			return ("Your water intake is very low. You need "+ String.format("%.2f", difference) + " more liters to reach optimal hydration.");
		}
		else if (difference > 0) {
			return ("Slightly below optimal. You need just "+ String.format("%.2f", difference) + " more liters.");
		}
		else {
			return ("Your water intake is optimal! Great job staying hydrated.");
		}
	}

	public int getMenuChoice() {
		return menuChoice;
	}

	public void setMenuChoice(int menuChoice) {
		this.menuChoice = menuChoice;
	}

	public int getDtGoal() {
		return dtGoal;
	}

	public void setDtGoal(int dtGoal) {
		this.dtGoal = dtGoal;
	}

	public int getDtIntensity() {
		return dtIntensity;
	}

	public void setDtIntensity(int dtIntensity) {
		this.dtIntensity = dtIntensity;
	}

	public double getWaterIntake() {
		return waterIntake;
	}

	public void setWaterIntake(double waterIntake) {
		this.waterIntake = waterIntake;
	}

	public void showDietOptions(int dtGoal, int dtIntensity) {
		System.out.println("              MENU 1              ");
		showDietMenu(dtGoal, dtIntensity, 1);

		System.out.println("              MENU 2              ");
		showDietMenu(dtGoal, dtIntensity, 2);

		System.out.println("              MENU 3              ");
		showDietMenu(dtGoal, dtIntensity, 3);

		System.out.println("              MENU 4              ");
		showDietMenu(dtGoal, dtIntensity, 4);

		System.out.println("Now choose your menu");

	}

	public void showDietMenu(int dtGoal, int dtIntensity, int menuChoice) {
		if (dtGoal == 1 && dtIntensity == 1) {
			if (menuChoice == 1) {
				System.out.print("""
						Diet (Bulking Beginner) - Menu 1:
						Breakfast: Eggs + Oats + Milk
						Lunch: Chicken + Rice
						Dinner: Beef + Pasta
						Snacks: Peanut Butter Sandwich

						""");
			} else if (menuChoice == 2) {
				System.out.print("""
						Diet (Bulking Beginner) - Menu 2:
						Breakfast: Oats + Banana + Greek Yogurt
						Lunch: Pasta + Chicken Breast
						Dinner: Salmon + Potatoes
						Snacks: Almonds + Fruit

						""");
			} else if (menuChoice == 3) {
				System.out.print("""
						Diet (Bulking Beginner) - Menu 3:
						Breakfast: Peanut Butter + Honey Sandwich + Milk
						Lunch: Beef + Rice + Vegetables
						Dinner: Chicken + Pasta + Olive Oil
						Snacks: Protein Shake + Banana

						""");
			} else {
				System.out.print("""
						Diet (Bulking Beginner) - Menu 4:
						Breakfast: Eggs + Toast + Cheese
						Lunch: Turkey + Rice + Salad
						Dinner: Tuna Pasta + Olive Oil
						Snacks: Yogurt + Oats

						""");
			}
			return;
		}

		if (dtGoal == 1 && dtIntensity == 2) {
			if (menuChoice == 1) {
				System.out.print("""
						Diet (Bulking Intermediate) - Menu 1:
						Breakfast: Omelette + Wholegrain Toast + Fruit
						Lunch: Grilled Chicken + Brown Rice + Veggies
						Dinner: Salmon + Sweet Potato
						Snacks: Greek Yogurt + Nuts

						""");
			} else if (menuChoice == 2) {
				System.out.print("""
						Diet (Bulking Intermediate) - Menu 2:
						Breakfast: Protein Oats + Banana
						Lunch: Turkey Sandwich + Salad
						Dinner: Beef Stew + Rice
						Snacks: Cottage Cheese + Fruit

						""");
			} else if (menuChoice == 3) {
				System.out.print("""
						Diet (Bulking Intermediate) - Menu 3:
						Breakfast: Eggs + Avocado Toast
						Lunch: Chicken Pasta + Olive Oil
						Dinner: Pork + Potatoes + Veggies
						Snacks: Trail Mix

						""");
			} else {
				System.out.print("""
						Diet (Bulking Intermediate) - Menu 4:
						Breakfast: Smoothie (milk, oats, peanut butter)
						Lunch: Tuna + Quinoa + Veggies
						Dinner: Steak + Rice + Salad
						Snacks: Greek Yogurt + Honey

						""");
			}
			return;
		}

		if (dtGoal == 1 && dtIntensity == 3) {
			if (menuChoice == 1) {
				System.out.print("""
						Diet (Bulking Advanced) - Menu 1:
						Breakfast: 6 Eggs + Oats + Fruit
						Lunch: Turkey + Pasta + Salad
						Dinner: Steak + Rice
						Snacks: Protein Shake + Peanut Butter

						""");
			} else if (menuChoice == 2) {
				System.out.print("""
						Diet (Bulking Advanced) - Menu 2:
						Breakfast: Large Omelette + Sweet Potato
						Lunch: Salmon + Brown Rice + Veggies
						Dinner: Lamb + Potatoes
						Snacks: Nuts + Greek Yogurt

						""");
			} else if (menuChoice == 3) {
				System.out.print("""
						Diet (Bulking Advanced) - Menu 3:
						Breakfast: Pancakes + Eggs + Fruit
						Lunch: Chicken Alfredo + Pasta
						Dinner: Beef Stir Fry + Rice
						Snacks: Peanut Butter + Banana Smoothie

						""");
			} else {
				System.out.print("""
						Diet (Bulking Advanced) - Menu 4:
						Breakfast: Protein Shake + Steel Oats + Berries
						Lunch: Mixed Grill + Rice
						Dinner: Seafood Pasta
						Snacks: Cottage Cheese + Nuts

						""");
			}
			return;
		}

		if (dtGoal == 2 && dtIntensity == 1) {
			if (menuChoice == 1) {
				System.out.print("""
						Diet (Cutting Beginner) - Menu 1:
						Breakfast: Oats + Boiled Egg
						Lunch: Grilled Chicken + Salad
						Dinner: Tuna + Vegetables
						Snacks: Apple or Yogurt

						""");
			} else if (menuChoice == 2) {
				System.out.print("""
						Diet (Cutting Beginner) - Menu 2:
						Breakfast: Greek Yogurt + Berries
						Lunch: Turkey Salad
						Dinner: Vegetable Stir Fry + Tofu
						Snacks: Carrot Sticks + Hummus

						""");
			} else if (menuChoice == 3) {
				System.out.print("""
						Diet (Cutting Beginner) - Menu 3:
						Breakfast: Smoothie (spinach, banana, protein)
						Lunch: Grilled Fish + Steamed Veggies
						Dinner: Chicken Soup + Salad
						Snacks: Rice Cakes + Peanut Butter

						""");
			} else {
				System.out.print("""
						Diet (Cutting Beginner) - Menu 4:
						Breakfast: Egg Whites + Wholegrain Toast
						Lunch: Quinoa Salad + Chickpeas
						Dinner: Baked Fish + Veggies
						Snacks: Nuts (small handful)

						""");
			}
			return;
		}

		if (dtGoal == 2 && dtIntensity == 2) {
			if (menuChoice == 1) {
				System.out.print("""
						Diet (Cutting Intermediate) - Menu 1:
						Breakfast: Egg Whites + Avocado
						Lunch: Chicken Breast + Brown Rice
						Dinner: Fish + Salad
						Snacks: Cottage Cheese

						""");
			} else if (menuChoice == 2) {
				System.out.print("""
						Diet (Cutting Intermediate) - Menu 2:
						Breakfast: Protein Oats
						Lunch: Turkey + Sweet Potato
						Dinner: Lean Beef + Veggies
						Snacks: Greek Yogurt + Seeds

						""");
			} else if (menuChoice == 3) {
				System.out.print("""
						Diet (Cutting Intermediate) - Menu 3:
						Breakfast: Protein Shake + Fruit
						Lunch: Tuna + Salad
						Dinner: Stir Fry Veggies + Tofu
						Snacks: Edamame

						""");
			} else {
				System.out.print("""
						Diet (Cutting Intermediate) - Menu 4:
						Breakfast: Cottage Cheese + Fruit
						Lunch: Salmon + Quinoa
						Dinner: Chicken + Veggies
						Snacks: Mixed Nuts (small)

						""");
			}
			return;
		}

		if (dtGoal == 2 && dtIntensity == 3) {
			if (menuChoice == 1) {
				System.out.print("""
						Diet (Cutting Advanced) - Menu 1:
						Breakfast: Protein Shake + Fruit
						Lunch: Turkey + Vegetables
						Dinner: Fish + Salad
						Snacks: Almonds

						""");
			} else if (menuChoice == 2) {
				System.out.print("""
						Diet (Cutting Advanced) - Menu 2:
						Breakfast: Egg White Omelette + Veggies
						Lunch: Grilled Chicken + Spinach
						Dinner: Shrimp + Zoodles
						Snacks: Celery + Peanut Butter

						""");
			} else if (menuChoice == 3) {
				System.out.print("""
						Diet (Cutting Advanced) - Menu 3:
						Breakfast: Greek Yogurt + Seeds
						Lunch: Tuna + Avocado Salad
						Dinner: Baked Cod + Broccoli
						Snacks: Protein Bar (low sugar)

						""");
			} else {
				System.out.print("""
						Diet (Cutting Advanced) - Menu 4:
						Breakfast: Smoothie (greens + protein)
						Lunch: Lean Beef + Veggies
						Dinner: Salmon + Asparagus
						Snacks: Small Handful of Nuts

						""");
			}
			return;
		}

		System.out.println("No diet menu found for this selection.");
	}

	@Override
	public String toString() {
		return "Menu Choice: " + menuChoice + ", Diet Goal: " + dtGoal + ", Diet Intensity: " + dtIntensity
				+ ", Water Intake: " + waterIntake;
	}

	@Override
	public String getSummary() {
		return toString();
	}

}
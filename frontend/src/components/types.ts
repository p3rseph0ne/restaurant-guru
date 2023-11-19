interface Allergies{
    Gluten: boolean,
    Fish: boolean,
    Nuts: boolean,
    Egg: boolean,
    Shellfish: boolean,
    Lupins: boolean,
    Lactose: boolean,
    Peanut: boolean,
    Molluscs: boolean,
    Soybeans: boolean,
    SesameSeeds: boolean,
    Mustard: boolean,
    Celery: boolean,
    Sulfites: boolean,
  } 
  interface Preferences{
    Asian: boolean,
    Austrian: boolean,
    Italian: boolean,
  }
  
  interface Person {
    name: string;
    allergies: Allergies;
    preferences: Preferences;
    isVeggy: boolean;
    isVegan: boolean;
    isCustomer: boolean;
    isPaying: boolean;
  }

  interface Restaurant {
    name: string;
    address: string;
  }

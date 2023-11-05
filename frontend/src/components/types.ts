interface Allergies{
    A: boolean,
    B: boolean,
    C: boolean,
    D: boolean,
    E: boolean,
    F: boolean,
    G: boolean,
    H: boolean,
    L: boolean,
    M: boolean,
    N: boolean,
    O: boolean,
    P: boolean,
    R: boolean,
  } 
  interface Preferences{
    asian: boolean,
    austrian: boolean,
    italian: boolean,
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

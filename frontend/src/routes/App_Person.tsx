import { useState } from "react";
import "../App.css";
import { Checkbox } from "../components/Checkbox";
import "../components/types.ts";
import {
  Button,
  FormControlLabel,
  TextField,
} from "@mui/material";
import CheckboxMUI from "@mui/material/Checkbox";
import Header from "../components/Header";

const allergies: Allergies = {
  A: false,
  B: false,
  C: false,
  D: false,
  E: false,
  F: false,
  G: false,
  H: false,
  L: false,
  M: false,
  N: false,
  O: false,
  P: false,
  R: false,
};

const preferences: Preferences = {
  asian: false,
  austrian: false,
  italian: false,
};

function App() {
  const [person, setPerson] = useState<Person>({
    name: "",
    allergies: allergies,
    preferences: preferences,
    isVeggy: false,
    isVegan: false,
    isCustomer: false,
    isPaying: false,
  });

  const handleCheckbox = (
    e: React.ChangeEvent<HTMLInputElement>,
    type: "allergies" | "preferences"
  ) => {
    let object = person[type as keyof Person];
    let key = e.target.name as keyof object;
    object[key] = !object[key];
    setPersonObject(type, object as Allergies | Preferences);
  };

  const handleNameField = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPersonObject(e.target.name, e.target.value);
  };

  function setPersonObject(
    key: string,
    value: string | boolean | Allergies | Preferences
  ) {
    setPerson({
      ...person,
      [key]: value,
    });
  }

  function checkPerson() {
    let allergylist: string[] = [];
    let preferencelist: string[] = [];
    let endpoint = "";
    let person_body = "";

    for (const allergy in allergies) {
      if (allergies[allergy]) {
        allergylist.push(allergy);
      }
    }

    for (const preference in preferences) {
      if (preferences[preference]) {
        preferencelist.push(preference);
      }
    }

    if (person.isCustomer) {
      endpoint = "http://localhost:4567/add-customer";
      person_body = JSON.stringify({
        name: person.name,
        allergies: allergylist,
        preferences: preferencelist,
        isVegan: person.isVegan,
        isVeggy: person.isVeggy,
        isPaying: person.isPaying,
      });
    } else {
      endpoint = "http://localhost:4567/add-employee";
      person_body = JSON.stringify({
        name: person.name,
        allergies: allergylist,
        preferences: preferencelist,
        isVegan: person.isVegan,
        isVeggy: person.isVeggy,
      });
    }

    createPerson(endpoint, person_body);
  }

  async function createPerson(endpoint: string, person_body: string) {
    try {
      await fetch(endpoint, {
        method: "POST",
        body: person_body,
      });

      setPerson({
        name: "",
        allergies: allergies,
        preferences: preferences,
        isVeggy: false,
        isVegan: false,
        isCustomer: false,
        isPaying: false,
      });
    } catch (e) {
      console.error(e);
    }
  }

  return (
    <div className="pagecontainer">
      <Header />
      <div className="formcontainer">
        <div className="form">
          <div className="flex-container">
            <h3>Name:</h3>
            <label>
              <TextField
                required
                fullWidth
                label="name"
                value={person.name}
                name="name"
                type="text"
                id="personNameInput"
                variant="filled"
                size="small"
                onChange={handleNameField}
              />
            </label>
            <h3>Allergies:</h3>
            <div>
              {Object.keys(allergies).map((key) => {
                return (
                  <Checkbox
                    label={key}
                    value={person.allergies[key as keyof Allergies]}
                    onChange={(e) => handleCheckbox(e, "allergies")}
                    name={key}
                  />
                );
              })}
            </div>

            <h3>Preferences:</h3>
            <div>
              {Object.keys(preferences).map((key) => {
                return (
                  <Checkbox
                    label={key}
                    value={person.preferences[key as keyof Preferences]}
                    onChange={(e) => handleCheckbox(e, "preferences")}
                    name={key}
                  />
                );
              })}
            </div>

            <h3>Special eating habits:</h3>
            <FormControlLabel
              label="Vegetarian"
              control={
                <CheckboxMUI
                  checked={person.isVeggy}
                  onChange={(e) => setPersonObject("isVeggy", e.target.checked)}
                  name="isVeggy"
                />
              }
            />
            <FormControlLabel
              label="Vegan"
              control={
                <CheckboxMUI
                  checked={person.isVegan}
                  onChange={(e) => setPersonObject("isVegan", e.target.checked)}
                  name="isVegan"
                />
              }
            />
            <h3>Are you creating a customer?</h3>
            <div>
              <FormControlLabel
                label="Person is a customer"
                control={
                  <CheckboxMUI
                    checked={person.isCustomer}
                    onChange={(e) =>
                      setPersonObject("isCustomer", e.target.checked)
                    }
                    name="isCustomer"
                  />
                }
              />

              <FormControlLabel
                label="Customer is Paying"
                control={
                  <CheckboxMUI
                    value="Name"
                    id="isPaying"
                    checked={person.isPaying}
                    onChange={(e) =>
                      setPersonObject("isPaying", e.target.checked)
                    }
                    name="isPaying"
                    disabled={!person.isCustomer}
                  />
                }
              />
            </div>
            <div>
              <Button
                className="buttons"
                variant="contained"
                type="submit"
                onClick={checkPerson}
                disabled={!person || person.name.length === 0}
              >
                Create your lovely Co-Worker or Customer
              </Button>
            </div>
          </div>
        </div>
      </div>
      //DGSVO auf süß?
    </div>
  );
}

export default App;

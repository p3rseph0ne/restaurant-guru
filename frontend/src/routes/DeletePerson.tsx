import { useEffect, useState } from "react";
import "../components/types.ts";
import "../App.css";
import "../components/types.ts";
import {
  Button,
  FormControl,
  FormControlLabel,
  RadioGroup,
  Radio,
} from "@mui/material";


function DeletePerson() {
  const [availablePersonList, setAvailablePersonList] = useState<Person[]>([]);
  const [checkedPerson, setCheckedePerson] = useState<String>();


  useEffect(() => {
    getAvailablePersonList();
  }, []);

  const handleCheckbox = (
    e: React.ChangeEvent<HTMLInputElement>,
    name: String
  ) => {
    if (!e.target.checked) {
      setCheckedePerson("");
    } else if (e.target.checked) {
      setCheckedePerson(name);
    }
  };

  async function getAvailablePersonList() {
    try {
      const response = await fetch("http://localhost:4567/restaurant");
      const personList = (await response.json()) as Person[];

      setAvailablePersonList(personList);
    } catch (e) {
      console.error(e);
    }
  }

  async function deletePerson() {
    try {
      const response = await fetch(
        "http://localhost:4567/delete-person",
        {
          method: "POST",
          body: JSON.stringify({
            checkedPerson: checkedPerson,
          }),
        }
      );
      getAvailablePersonList();
    } catch (e) {
      console.error(e);
    }

    
  }

  return (
      <div className="formcontainer">
        <div className="form">
          <div className="flex-container">
            <h3>Who's unneccessary?</h3>
            <label>
              <div className="persons">
                <FormControl component="fieldset">
                  <RadioGroup aria-label="position" row>
                    {availablePersonList?.map((person) => (
                      <FormControlLabel
                        value={person.name}
                        control={
                          <Radio
                            onChange={(e) => handleCheckbox(e, person.name)}
                          />
                        }
                        label={person.name}
                      />
                    ))}
                  </RadioGroup>
                </FormControl>
              </div>
            </label>
            <Button
              variant="contained"
              type="submit"
              onClick={() => deletePerson()}
            >
              MAKE THEM LEAVE
            </Button>
          </div>
        </div>
      </div>
  )
}

export default DeletePerson;

import { useEffect, useState } from "react";
import "../components/types.ts";
import "../App.css";
import "../components/types.ts";
import {
  Box,
  Button,
  FormControl,
  FormControlLabel,
  FormGroup,
  Modal,
  Radio,
  RadioGroup,
  Typography,
} from "@mui/material";
import CheckboxMUI from "@mui/material/Checkbox";

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

const weekdays = [
  "Monday",
  "Tuesday",
  "Wednesday",
  "Thursday",
  "Friday",
  "Saturday",
];
const timeframes = ["11:00", "12:00", "13:00"];

function Restaurant() {
  const [availablePersonList, setAvailablePersonList] = useState<Person[]>([]);
  const [checkedPersonList, setCheckedePersonList] = useState<Person[]>([]);
  const [day, setDay] = useState<String>("");
  const [time, setTime] = useState<String>("");
  const [restaurant, setRestaurant] = useState<Restaurant>({
    name: "",
    address: "",
  });
  const [isOpen, setIsOpen] = useState<boolean>(false)

  useEffect(() => {
    getAvailablePersonList();

    return () => {
      setCheckedePersonList([]);
      setAvailablePersonList([]);
    }
  }, []);

  const handleCheckbox = (
    e: React.ChangeEvent<HTMLInputElement>,
    person: Person
  ) => {
    if (!e.target.checked) {
      const updatedCheckPersonList = checkedPersonList.filter((checkedPersonList) => {
        return checkedPersonList.name !== e.target.value;
      });
      setCheckedePersonList(updatedCheckPersonList)
    } else if (e.target.checked) {
      setCheckedePersonList((prev) => [...prev, person]);
    }
  };

  const handleDayChange = (newDay: string) => {
    setDay(newDay);
  };

  const handleTimeChange = (newTime: string) => {
    setTime(newTime);
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

  async function getRestaurant() {
    try {
      const response = await fetch(
        "http://localhost:4567/restaurant/whatsforlunchmum",
        {
          method: "POST",
          body: JSON.stringify({
            checkedPerson: checkedPersonList,
            day: day,
            time: time
          }),
        }
      );

      const restaurantJson = (await response.json()) as Restaurant;
  
      if (restaurantJson.name) {
        setIsOpen(true)
      }

      setRestaurant(restaurantJson);
    } catch (e) {
      console.error(e);
    }
  }

  console.log(restaurant);

  return (
     <div className="formcontainer">
        <div className="form">
          <div className="flex-container">
            <h3>Who's coming?</h3>
            <label>
              <div className="persons">
                <FormControl component="fieldset">
                  <FormGroup aria-label="position" row>
                    {availablePersonList?.map((person) => (
                      <FormControlLabel
                        value={person.name}
                        control={
                          <CheckboxMUI
                            onChange={(e) => handleCheckbox(e, person)}
                          />
                        }
                        label={person.name}
                      />
                    ))}
                  </FormGroup>
                </FormControl>
              </div>
            </label>
            <h3>What day are y'all planning to go?</h3>
            <label>
              <div>
                <RadioGroup name="radio-buttons-group">
                  {weekdays?.map((day) => (
                    <FormControlLabel
                      label={day}
                      value={day}
                      control={<Radio onChange={() => handleDayChange(day)} />}
                    />
                  ))}
                </RadioGroup>
              </div>
            </label>
            <h3>
              Alright hungry fella, last question. What time do you wanna dine?
            </h3>
            <label>
              <div>
                <RadioGroup name="radio-buttons-group">
                  {timeframes?.map((hour) => (
                    <FormControlLabel
                      label={hour}
                      value={hour}
                      control={
                        <Radio onChange={() => handleTimeChange(hour)} />
                      }
                    />
                  ))}
                </RadioGroup>
              </div>
            </label>

            <div>
              <Button
                className="buttons"
                variant="contained"
                type="submit"
                onClick={() => getRestaurant()}
                disabled={!checkedPersonList || !day || !time}
              >
                Whats for lunch mum????
              </Button>
            </div>

            <Modal open={isOpen} onClose={() => setIsOpen(false)}>
            <Box className="modalContainer">
              <Box className="modalContent">
                <Typography>
                  Restaurant
                </Typography>
                <Typography>
                {restaurant.name}
                </Typography>
                <Typography>
                  Adress
                </Typography>
                <Typography>
                {restaurant.address}
                </Typography>
              </Box>
            </Box>
            </Modal>
          </div>
        </div>
      </div>
  );
}

export default Restaurant;

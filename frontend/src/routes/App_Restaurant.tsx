import { useEffect, useState } from 'react'
import '../components/types.ts';

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
  }
  
  const preferences: Preferences = {
    asian: false,
    austrian: false,
    italian: false,
  }

  const weekdays = ["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]
  const timeframes = ["11:00","12:00","13:00"]



function Restaurant() {
  const[availablePersonList, setAvailablePersonList] = useState<Person[]>([])
  const[checkedPersonList, setCheckedePersonList] = useState<Person[]>([])
  const[day, setDay] = useState<String>("")
  const[time, setTime] = useState<String>("")
  const[restaurant,setRestaurant] = useState<Restaurant>({
    name: "",
    address: ""
  })



  useEffect(()=>{
      getAvailablePersonList()
  }, [])


  const handleCheckbox = (person: Person) => {
      setCheckedePersonList((prev) => [...prev, person])
  };


  const handleDayChange = (newDay: string) => {
    setDay(newDay)
  }

  const handleTimeChange = (newTime: string) => {

    setTime(newTime)
  }

  async function getAvailablePersonList() {  
      try {
          const response = await fetch("http://localhost:4567/restaurant");
          const personList = await response.json() as Person[]

          setAvailablePersonList(personList)
      } catch (e) {
          console.error(e)
      }
           
  }

  async function getRestaurant(){
    try {
        const response = await fetch("http://localhost:4567/restaurant/whatsforlunchmum", {
          method: 'POST',
          body: JSON.stringify({
            checkedPerson: checkedPersonList,
            day: day,
            time: time
          })
        })

        const restaurantJson = (await response.json()) as Restaurant
        console.log(restaurantJson)

        setRestaurant(restaurantJson)
        
      } catch (e) {
        console.error(e)
      }     
    
  }

  console.log(restaurant)

  return (
    <div className="formContainer">
      <label>
        <div className="checkboxGrid">
        {availablePersonList?.map(person => <div key={person.name}><input type="checkbox" onChange={() => handleCheckbox(person)} name ={person.name}/>{person.name}</div>)}
        </div>
      </label>
      <label>
        <div className="checkboxGrid">
          {weekdays?.map(day => <div key={day}><input type="radio" onChange={() => handleDayChange(day)} name="day" value={day}/>{day}</div>)}
        </div>
      </label>
      <label> 
        <div className="checkboxGrid">
          {timeframes?.map(hour => <div key={hour}><input type="radio" onChange={() => handleTimeChange(hour)} name ="time" value={hour}/>{hour}</div>)}
        </div>
      </label>
      <label>
        <div>
          <button onClick={() => getRestaurant()}>Whats for lunch mum????</button>
        </div>
      </label>
      <div>
          {restaurant.name};{restaurant.address}
      </div>
    </div>
    
  )
}

export default Restaurant

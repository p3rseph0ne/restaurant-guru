import { useEffect, useState } from 'react'
import '../components/types.ts';
import { Checkbox } from '../components/Checkbox';

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




function Restaurant() {
  const[personList, setPersonList] = useState<Person[]>([])

  useEffect(()=>{
      getPersonList()
  })

  const handleCheckbox = () => {
      
  };

  async function getPersonList(){
      try {
          const response = await fetch("http://localhost:4567/restaurant");
          const personList = await response.json() as Person[]

          setPersonList(personList)
        } catch (e) {
          console.error(e)
        }     
  }

  return (
    <div className="formContainer">
      <label>
        <input type="checkbox"  onChange={(e) => handleCheckbox()} name ='test'/>
        {personList?.map(person => <div key={person.name}>{person.name}</div>)}
      </label>
    </div>
    
  )
}

export default Restaurant

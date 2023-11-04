import { useState } from 'react'
import './App.css'
import { Checkbox } from './components/Checkbox';

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

function App() {

  const [person, setPerson] = useState<Person>({
    name: '',
    allergies: allergies,
    preferences: preferences,
    isVeggy: false,
    isVegan: false,
    isCustomer: false,
    isPaying: false
  })

  const handleCheckbox = (e: React.ChangeEvent<HTMLInputElement>, type: 'allergies' | 'preferences') => {
    let object = person[type as keyof Person]
    let key = e.target.name as keyof object
    object[key] = !object[key]
    setPersonObject(type, object as Allergies | Preferences)
  };

  const handleNameField = (e: React.ChangeEvent<HTMLInputElement>) => {
    setPersonObject(e.target.name, e.target.value)
  };
  
  function setPersonObject(key: string,  value: string | boolean | Allergies | Preferences) {
    setPerson({
      ...person,
      [key]: value
    })
  }


  async function createPerson() {
    try {
      await fetch("http://localhost:4567/add-person", {
        method: 'POST',
        body: JSON.stringify({
          name: person.name,
          allergies: person.allergies,
          preferences: person.preferences,
          isVeggy: person.isVeggy,
          isVegan: person.isVegan,
          isPaying: person.isPaying
        })
      })

      setPerson({
        name: '',
        allergies: allergies,
        preferences: preferences,
        isVeggy: false,
        isVegan: false,
        isCustomer: false,
        isPaying: false
      })
    } catch (e) {
      console.error(e)
    }
  }

  return (
    <div className="formContainer">
      <label htmlFor='personNameInput'>Name:</label>
      <input id="personNameInput" onChange={handleNameField} value={person.name} name='name'/>
      <label htmlFor='allergyInput'>Allergies:</label>
      <div className="checkboxGrid">
        {Object.keys(allergies).map(key => { 
        return <Checkbox label={key} value={person.allergies[key as keyof Allergies]} onChange={(e) => handleCheckbox(e,'allergies')} name={key}/>
        })}
      </div>

      <label htmlFor='preferenceInput'>Preferences:</label>
      <div className="checkboxGrid">
        {Object.keys(preferences).map(key => { 
        return <Checkbox label={key} value={person.preferences[key as keyof Preferences]} onChange={(e) => handleCheckbox(e,'preferences')} name={key}/>
        })}
      </div>

      <label htmlFor='eatingHabits'>Special eating habits:</label>
      <div className="checkboxGrid">
        <input type="checkbox" checked={person.isVeggy} onChange={(e) => setPersonObject('isVeggy', e.target.checked)} name ='isVeggy'/> Vegetarian
      </div>
      <div className="checkboxGrid">
        <input type="checkbox" checked={person.isVegan} onChange={(e) => setPersonObject('isVegan', e.target.checked)} name ='isVegan'/> Vegan
      </div>
      <div className="checkboxGrid">
        <input type="checkbox" checked={person.isCustomer} onChange={(e) => setPersonObject('isCustomer', e.target.checked)} name ='isCustomer'/> Customer
      </div>
      <div className="checkboxGrid">
        <input type="checkbox" checked={person.isPaying} onChange={(e) => setPersonObject('isPaying', e.target.checked)} name ='isPaying' disabled={!person.isCustomer}/> Customer pays
      </div>

      <button onClick={createPerson} disabled={!person || person.name.length === 0}>Person anlegen</button>
    </div>
  )
}

export default App

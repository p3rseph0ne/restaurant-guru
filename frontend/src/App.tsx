import { useState } from 'react'
import './App.css'

function App() {
  const [restaurantName, setRestaurantName] = useState<string>('')

  async function getRestaurantName() {
    try {
      const result = await fetch("http://localhost:4567/restaurant", {
        method: 'GET'
      })
      const name = await result.text()

      setRestaurantName(name)

    } catch (e) {
      console.error(e)
    }
  }

  async function createRestaurant() {
    try {
      await fetch("http://localhost:4567/add-restaurant", {
        method: 'POST',
        body: JSON.stringify({
          name: restaurantName
        })
      })

      setRestaurantName('')
    } catch (e) {
      console.error(e)
    }
  }

  return (
    <div className="formContainer">
      <label htmlFor='restaurantNameInput'>Enter Restaurant Name</label>
      <input id="restaurantNameInput" onChange={(e) => setRestaurantName(e.target.value)} value={restaurantName}/>
      <button onClick={createRestaurant} disabled={!restaurantName || restaurantName.length === 0}>Click me</button>
    </div>
  )
}

export default App

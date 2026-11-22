
// A root component App
// you must start the component name with capital letter
// it is used as a tag in other jsx/tsx files having other components


import ServiceItemList from "./components/ServiceItemList";

function App() {
  
  return (<div>
    <h1>Welcome to React + Vite</h1>
    
    <div>
      <ServiceItemList />
    </div>
  </div>);
}

export default App;
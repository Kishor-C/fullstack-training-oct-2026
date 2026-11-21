
// A root component App
// you must start the component name with capital letter
// it is used as a tag in other jsx/tsx files having other components


import ServiceItemList from "./components/ServiceItemList";

function App() {
  let simpleItems = ["Laptop", "Mobile", "Watch"];
  let complexItems = [{id:100, name:"Alex", gender:"M"}, {id:200, name:"Jennifer", gender:"F"}];
  return (<div>
    <h1>Welcome to React + Vite</h1>
    <div>
      <h2>List and Keys</h2>
      <ol>
        {simpleItems.map((item, index)=><li key={item}>{item}</li>)}
      </ol>
      <h2>List and Keys with complex items</h2>
      <div>
        {complexItems.map((item, index)=><p key = {item.id}>Name:{item.name}, Gender: {item.gender}</p>)}
      </div>
    </div>
      
    <div>
      <ServiceItemList />
    </div>
  </div>);
}

export default App;
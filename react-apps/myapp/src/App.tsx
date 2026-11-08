
// A root component App
// you must start the component name with capital letter
// it is used as a tag in other jsx/tsx files having other components

import ServiceItem from "./components/ServiceItem";

function App() {
  return (<div>
    <h1>Welcome to React + Vite</h1>
    <ServiceItem />
    <ServiceItem />
    <ServiceItem />
  </div>);
}

export default App;
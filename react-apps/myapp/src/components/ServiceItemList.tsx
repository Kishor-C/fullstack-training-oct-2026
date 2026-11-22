import { useEffect, useState } from "react";
import ServiceItem from "./ServiceItem";
import axios from "axios";

function ServiceItemList() {
    let [services, setServices] = useState([]); 
    //useEffect hook: 2nd argument is a list of variables that make useEffect to execute the callback
    // when they are changed
    useEffect(()=>{
        let URL = "http://localhost:3000/services";
        axios.get(URL)
        .then((res) => setServices(res.data))
        .catch((err) => console.log(err));
    },[]);
    return (
        <div>
            {
                services.map((service)=><ServiceItem key = {service.id} item = {service} />)
            }
        </div>
    )
}
export default ServiceItemList;
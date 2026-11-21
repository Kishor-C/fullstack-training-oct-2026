import ServiceItem from "./ServiceItem";

function ServiceItemList() {
    let service1 : any = {title : "Video Editing", price : "600", category : "Design", ratings : "4.9",
                description : "Editing videos with modern tools"};
    let service2: any = {title : "Logo Design", price : "300", category : "Design", ratings:"4.5",
                description : "Stylist logo that define your business branding and identity."};
    let service3 : any = {title : "Content Writing", price : "400", category : "Writing", ratings : "4.7",
                description : "SEO optimized articles for your software products."};

    return (
        <div>
            <ServiceItem item =  {service1} />
            <ServiceItem item =  {service2} />
            <ServiceItem item =  {service3} />
        </div>
    )
}
export default ServiceItemList;
function ServiceItem() {
    let title: string = "Web Application";
    let category: string = "IT";
    let price: number = 500;
    let ratings: number = 4.8;
    let description: string = "Build a modern web application with latest technology";
    return (<div>
        <h3>{title}</h3>
        <p>Category: {category}</p>
        <p>Price: {price}</p>
        <p>Ratings: {ratings}</p>
        <p>{description}</p>
    </div>)
}

export default ServiceItem;
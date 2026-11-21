function ServiceItem(props : any) {
    let {title, category, price, ratings, description} = props.item;
    return (<div>
        <h3>{title}</h3>
        <p>Category: {category}</p>
        <p>Price: {price}</p>
        <p>Ratings: {ratings}</p>
        <p>{description}</p>
    </div>)
}

export default ServiceItem;
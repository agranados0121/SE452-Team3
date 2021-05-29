function incrementValue()
{
    var value = parseInt(document.getElementById('cart_value').value, 10);
    value = isNaN(value) ? 0 : value;
    value++;
    document.getElementById('cart_value').value = value;
}

hello,${name}.<br />
age:${age}
Car:<br />
	name:${car.name}<br />
	price:${car.price}
	Car info:<br />
	<#list car?keys as x>
		${x}--->${car[x]};<br />
	</#list>
	<#list list as ss>
		${ss}<br />
	</#list>

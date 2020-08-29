let materials = [
	{
		"name":"zirconium",
		"alloy":false
	},
	{
		"name":"zircaloy",
		"alloy":true
	},
	{
		"name":"tin",
		"alloy":false
	},
	{
		"name":"copper",
		"alloy":false
	},
	{
		"name":"allactite",
		"alloy":false
	},
	{
		"name":"sapphire",
		"alloy":false
	},
	{
		"name":"shivorium",
		"alloy":false
	}
]

for(material of materials)
{
	blockstate(material.name, 'block')
	if(!material.alloy) blockstate(material.name, 'ore')
}

function blockstate(name, type)
{
	const fs = require('fs')
	let model = {
	"forge_marker": 1,
	"defaults": {
		"model": "minecraft:cube_all",
		"textures": {
			"all": `tinkersworld:blocks/material/${name}_${type}`,
			"particle": "#all"
		}
	},
	"variants": {
		"normal": [{}],
		"inventory": [{}]
	}
	}
	fs.writeFileSync(`./${name}_${type}.json`, JSON.stringify(model, null, 2), 'utf8')
}
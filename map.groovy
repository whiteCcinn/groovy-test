def map = [:]


// 有特殊符号的时候需要用引号括起来
map."an identifier with a space and double quotes" = "ALLOWED"
map.'with-dash-signs-and-single-quotes' = "ALLOWED"

// 常规的key不需要处理
map.var = 123

assert map."an identifier with a space and double quotes" == "ALLOWED"
assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"
assert map.var == 123


map.'single quote'
map."double quote"
map.'''triple single quote'''
map."""triple double quote"""
map./slashy string/ = 'slashy string'
map.$/dollar slashy string/$ = 'dollar slashy string'

// error
// map.$dollar slashy string$ = 'dollar string'

println map.'single quote'
println map./slashy string/
println map.$/dollar slashy string/$


def firstname = "Homer"
def secondname = "Homer2"
map."Simpson-${firstname}" = "Homer Simpson"
map.'Simpson-${secondname}' = "Homer Simpson2"

assert map.'Simpson-Homer' == "Homer Simpson"
assert map.'Simpson-Homer2' == "Homer Simpson2"  // failed


// Groovy有时有时在其他语言中称为字典或关联数组，具有地图功能。映射将键与值相关联，将键和值之间用冒号分隔，将每个键/值对之间用逗号分隔，并将整个键和值括在方括号中。

def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']   

assert colors['red'] == '#FF0000'    
assert colors.green  == '#00FF00'    

colors['pink'] = '#FF00FF'           
colors.yellow  = '#FFFF00'           

assert colors.pink == '#FF00FF'
assert colors['yellow'] == '#FFFF00'

assert colors instanceof java.util.LinkedHashMap

// 如果您尝试访问地图中不存在的钥匙：

assert colors.unknown == null


// 当需要在映射定义中将变量值作为键传递时，必须用括号将变量或表达式括起来：

person = [(key): 'Guillaume']        

assert person.containsKey('name')    
assert !person.containsKey('key') 
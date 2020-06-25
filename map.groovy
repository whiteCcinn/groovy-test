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
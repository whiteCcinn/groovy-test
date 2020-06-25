// Groovy提供了多种表示String字面量的方法。 Groovy中的字符串可以用单引号（'），双引号（“）或三引号（”“”）括起来。此外，由三重引号括起来的Groovy字符串可以跨越多行。
/**
文本文字以称为字符串的字符链的形式表示。Groovy使您可以实例化java.lang.String对象以及GStrings（groovy.lang.GString），它们在其他编程语言中也称为内插字符串。
*/


String sample = "Hello world"; 
println(sample[4]); // Print the 5 character in the string

//Print the 1st character in the string starting from the back 
println(sample[-1]); 
println(sample[1..2]);//Prints a string starting from Index 1 to 2 
println(sample[4..2]);//Prints a string starting from Index 4 back to 2 



//  单引号字符串是纯文本java.lang.String，不支持插值。也就是不需要内嵌变量

'a single-quoted string'

// 所有Groovy字符串都可以与+运算符连接

assert 'ab' == 'a' + 'b'

// 三重单引号字符串
/*
三重单引号的字符串是纯格式java.lang.String，不支持插值。
三重单引号字符串可以跨越多行。字符串的内容可以跨越行边界，而无需将字符串分成几段，也不需要串联或换行符：
*/

def aMultilineString = '''line one
line two
line three'''


def startingAndEndingWithANewline = '''
line one
line two
line three
'''

assert startingAndEndingWithANewline.startsWith('\n')

// 您会注意到，结果字符串包含换行符作为第一个字符。可以通过用反斜杠转义换行符来删除该字符：

def strippedFirstNewline = '''\
line one
line two
line three
'''

assert !strippedFirstNewline.startsWith('\n')

// 字符串插值

def name = 'Guillaume' // a plain string
def greeting = "Hello ${name}"

println greeting

assert greeting.toString() == 'Hello Guillaume'
assert greeting == 'Hello Guillaume'

// 任何Groovy表达式都是有效的，如在本示例中使用算术表达式所示：

def sum = "The sum of 2 and 3 equals ${2 + 3}"
assert sum.toString() == 'The sum of 2 and 3 equals 5'

// 插入值可以是表达式
sum = "The sum of 1 and 2 is equal to ${def a = 1; def b = 2; a + b}"

println sum
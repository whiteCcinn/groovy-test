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


def sParameterLessClosure = "1 + 2 == ${-> 3}" 
assert sParameterLessClosure == '1 + 2 == 3'

def sOneParamClosure = "1 + 2 == ${ w -> w << 3}" 
assert sOneParamClosure == '1 + 2 == 3'

/**

闭包是不带参数的无参数闭包。
在这里，闭包使用单个java.io.StringWriter参数，您可以使用<<leftShift运算符向其附加内容。无论哪种情况，两个占位符都是嵌入式闭包。
*/

// 从外观上看，它似乎是定义要内插的表达式的更详细的方法，但是闭包比单纯的表达式有一个有趣的优点：惰性求值。

def number = 1 
def eagerGString = "value == ${number}"
def lazyGString = "value == ${ -> number }"

assert eagerGString == "value == 1" 
assert lazyGString ==  "value == 1" 

number = 2 
assert eagerGString == "value == 1" 
assert lazyGString ==  "value == 2" 


String takeString(String message) {         
    assert message instanceof String        
    return message
}

def message = "The message is ${'hello'}"   
assert message instanceof GString           

def result = takeString(message)            
assert result instanceof String
assert result == 'The message is hello'



// 三重双引号字符串
// 三重双引号字符串的行为类似于双引号字符串，此外它们是多行的，例如三重单引号字符串。
// 双引号或单引号都不需要在三重双引号字符串中转义。

def name = 'Groovy'
def template = """
    Dear Mr ${name},

    You're the winner of the lottery!

    Yours sincerly,

    Dave
"""

assert template.toString().contains('Groovy')


/**
除了通常引用的字符串外，Groovy还提供斜线字符串，它们/用作开始和结束定界符。斜线字符串对于定义正则表达式和模式特别有用，因为不需要转义反斜杠。
*/

def fooPattern = /.*foo.*/
assert fooPattern == '.*foo.*'

def escapeSlash = /The character \/ is a forward slash/
assert escapeSlash == 'The character / is a forward slash'

// 斜线字符串为多行：

def multilineSlashy = /one
    two
    three/

assert multilineSlashy.contains('\n')

// 斜线字符串可以被认为是定义GString的另一种方式，但是具有不同的转义规则。因此，它们支持插值：

def color = 'blue'
def interpolatedSlashy = /a ${color} car/

assert interpolatedSlashy == 'a blue car'


// 美元斜线字符串是多行GString，以一个开头$/和一个结尾定界/$。转义字符是美元符号，它可以转义另一个美元或正斜杠。

def name = "Guillaume"
def date = "April, 1st"

def dollarSlashy = $/
    Hello $name,
    today we're ${date}.

    $ dollar sign
    $$ escaped dollar sign
    \ backslash
    / forward slash
    $/ escaped forward slash
    $$$/ escaped opening dollar slashy
    $/$$ escaped closing dollar slashy
/$

assert [
    'Guillaume',
    'April, 1st',
    '$ dollar sign',
    '$ escaped dollar sign',
    '\\ backslash',
    '/ forward slash',
    '/ escaped forward slash',
    '$/ escaped opening dollar slashy',
    '/$ escaped closing dollar slashy'
].every { dollarSlashy.contains(it) }



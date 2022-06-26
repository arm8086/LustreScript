import java.io.FileReader
import java.io.File
val digits = "0123456789"
val header = """int main() {
%s
}"""


fun transpileVariables(v: String): Any {
    if (v.contains("\"")) {
        return "string ${v.substring(4)}"
    } else {
        for (d in digits) {
            if (v.contains(d)) {
                return "int ${v.substring(4)}"
            }
        }
        return v
    }
}

fun main(args: Array<String>) {
    var input = args[0]
    var argv = arrayOf<String>()
    for (arg in args) {
        if (arg.startsWith("-")) {
            val list = argv.toMutableList()
            list.add(arg)
            argv = list.toTypedArray()
        }
    }
    var savename = input.split(".")[0]+".c"
    if (argv[0] == "-o") {
        savename = args[2]
    }
    var newfile = File(savename)
    var code = FileReader(input).readText()
    var newcode = ""
    for (line in code.split("\n")) {
       var nl = line
       transpileVariables(nl)
    }
    newfile.writeText(header.format(newcode))

}
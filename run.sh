#!/bin/bash
java -jar parser.jar "runTests"
diff -s AcceptanceTest_1_HTML_Output.txt TestFiles/AcceptanceTests/ExpectedA1_HTML.txt
diff -s AcceptanceTest_1_Latex_Output.txt TestFiles/AcceptanceTests/ExpectedA1_Latex.txt
diff -s AcceptanceTest_2_HTML_Output.txt TestFiles/AcceptanceTests/ExpectedA2_HTML.txt
diff -s AcceptanceTest_2_Latex_Output.txt TestFiles/AcceptanceTests/ExpectedA2_Latex.txt
diff -s AcceptanceTest_3_HTML_Output.txt TestFiles/AcceptanceTests/ExpectedA3_HTML.txt
diff -s AcceptanceTest_3_Latex_Output.txt TestFiles/AcceptanceTests/ExpectedA3_Latex.txt
diff -s AcceptanceTest_4_HTML_Output.txt TestFiles/AcceptanceTests/ExpectedA4_HTML.txt
diff -s AcceptanceTest_4_Latex_Output.txt TestFiles/AcceptanceTests/ExpectedA4_Latex.txt
diff -s AcceptanceTest_5_HTML_Output.txt TestFiles/AcceptanceTests/ExpectedA5_HTML.txt
diff -s AcceptanceTest_5_Latex_Output.txt TestFiles/AcceptanceTests/ExpectedA5_Latex.txt
diff -s AcceptanceTest_6_HTML_Output.txt TestFiles/AcceptanceTests/ExpectedA6_HTML.txt
diff -s AcceptanceTest_6_Latex_Output.txt TestFiles/AcceptanceTests/ExpectedA6_Latex.txt

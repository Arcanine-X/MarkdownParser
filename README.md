# Markdown Parser
This Markdown parser will take in a Markdown file and convert it to both correctly formatted HTML and Latex files.

## Please note that this program has to be run through the command line as it requires a file as a argument.

# To run the program
1. First either download the project and extract the zip, or `https://github.com/Arcanine-X/MarkdownParser`
2. Go to the top level directory (MarkdownParser)
3. To run the acceptance tests you first need to change the permissions
  - To change the permissions do `chmod +x run.sh`
  - Then you can do `./run.sh`
This will run all the unit tests and output how many unit tests passed. It should also run the acceptance test afterwards and output how many of the acceptance tests passed.
There are six acceptance tests that will be run and will be outputted to the appropriate files:
  - AcceptanceTest_1_HTML_Output.txt
  - AcceptanceTest_1_Latex_Output.txt
  - AcceptanceTest_2_HTML_Output.txt
  - AcceptanceTest_2_Latex_Output.txt
  - AcceptanceTest_3_HTML_Output.txt
  - AcceptanceTest_3_Latex_Output.txt
  - AcceptanceTest_4_HTML_Output.txt
  - AcceptanceTest_4_Latex_Output.txt
  - AcceptanceTest_5_HTML_Output.txt
  - AcceptanceTest_5_Latex_Output.txt
  - AcceptanceTest_6_HTML_Output.txt
  - AcceptanceTest_6_Latex_Output.txt

These outputs will automatically be compared with the expected results which can be found in TestFiles/AcceptanceTests

The script will use `diff -s` between the output and expected files and will display if the files are identical or not.

To run the program normally and pass in a text file which you want converted you can just do:
`java -jar parser.jar "filename.txt"` where filename is your file which should be located in the top level directory.
This will output two files appropriate files:
  - output_HTML.txt
  - output_Latex.txt

Or you can just run the tests with `java -jar parser.jar "runTests"`

# Features I have implemented

  - Paragraphs where blank lines create new paragraphs
  - Italic text working for all simple cases but will not support cases such as "wo\*rd*" where asterisk are in the middle of a word
  - Bold text works for all simple cases but again will not support cases such as "wo\*\*rd**" where asterisk are in 
  the middle of a word
  - Headings is supported up to H2 headings as the project specifies
  - Numbered lists work, however nesting is not supported
  - Bulleted lists work, again nesting is not supported
  - Separators work perfectly
  - Blockquotes also work perfectly
  - Inline code works for all simple cases but will not support cases such as "wo\`rd`" where the backticks are in the middle of a word
  - Block code works perfectly
  - Latex parsing works for all stated above

# Notes
  - All my HTML outputs were based and intended to match those outputted on : http://spec.commonmark.org/dingus/
  - Latex was new to me so I based all my latex syntax from
    - https://www.sharelatex.com/learn/Paragraphs_and_new_lines
    - https://www.sharelatex.com/learn/Bold,_italics_and_underlining
    - https://www.sharelatex.com/learn/Headers_and_footers
    - https://www.sharelatex.com/learn/Lists
    - https://tex.stackexchange.com/questions/286094/insert-code-keywords-inline?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    - https://tex.stackexchange.com/questions/325695/how-to-style-blockquote?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    - https://www.sharelatex.com/learn/Code_listing


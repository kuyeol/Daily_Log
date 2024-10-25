void reverse(char *str) {
    char * back = str;
    char temp;
    if (str) {

        while (*back) { // move back to end of string
            ++back;
        }
        back--;
        
        while (*str) {
            temp = *str;
            *str++ = *back;
            *back-- = temp;
        }
    }
}

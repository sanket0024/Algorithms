/*
@author - Sanket Mathur
*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
void reverseStr (char *input) {
	int i=0;
	//int *j;
	printf("Length of the string : %lu\n", strlen(input));
	for(i=0;i<strlen(input);i++) {
		//j = *input[i];
		printf("%s\n", &input[i]);
	}
}

int main() {
	/*int i=0, *j;
	j = &i;
	printf("%i\n", &i);*/
	//reverseStr("Sanket");
}
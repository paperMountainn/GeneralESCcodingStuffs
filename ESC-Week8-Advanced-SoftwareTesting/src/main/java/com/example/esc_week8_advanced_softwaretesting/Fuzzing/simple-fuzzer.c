#include <stdlib.h>
#include <assert.h>
#include <time.h>
#include <stdio.h>

int main() {
	char* input;
	int index;

	// strings of any length between 0 and 1024
	srand(time(NULL));
	int string_length = rand() % 1024;
	//printf("input length = %d\n", string_length);

	//allocate memory for the input
	input = (char *) malloc ((string_length+1) * sizeof(char));

	//generate a random character at each location of the string
	for (index = 0; index < string_length; index++) {
		double between_0_and_1 = (double)rand() / (double)RAND_MAX;
		//generate a character between ASCII 32 and 128
		input[index] = (int)(between_0_and_1 * 96 + 32);
	}
	input[string_length] = '\0';
	// here is the input string to fuzz
	printf("%s\n", input);
}

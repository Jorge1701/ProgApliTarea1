#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv[] )
{
        FILE *archivo;
        int caracter;

        archivo = fopen(argv[1],"r");

        if (archivo == NULL)
        {
            printf("\nError de apertura del archivo. \n\n");
        }
        else
        {

            while((caracter = fgetc(archivo)) != EOF)
            {

                printf("%c",caracter);
            }
        }
        fclose(archivo);
        return 0;
}



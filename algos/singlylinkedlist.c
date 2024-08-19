#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int value;
    struct node *next;
} node;

node* create(int val) {
    node *init = calloc(1, sizeof(*init)); 
    init->value = val;
    init->next = 0x0;    

    return init;
}

void insert(node *prev, int val) {    
    node *new = calloc(1, sizeof(*new));
    prev->next = new;
    new->value = val;
    new->next = 0x0;

    return;    
}

int main(void) {
    node *list = create(80085);

    printf("---------------------------\n");
    
    fprintf(stdout, "VALUE OF CURRENT NODE IS (%d)\n", list->value);
    fprintf(stdout, "POINTER OF NEXT NODE IS (%p)\n", list->next);

    printf("---------------------------\n");
    
    insert(list, 1337);
    fprintf(stdout, "VALUE OF CURRENT NODE IS (%d)\n", list->value);
    fprintf(stdout, "POINTER OF NEXT NODE IS (%p)\n", list->next);

    printf("---------------------------\n");
    
    fprintf(stdout, "VALUE OF CURRENT NODE IS (%d)\n", (list->next)->value);
    fprintf(stdout, "POINTER OF NEXT NODE IS (%p)\n", (list->next)->next);
    
    printf("---------------------------\n");

    return 0;
}

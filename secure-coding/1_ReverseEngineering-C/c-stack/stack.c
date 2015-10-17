#include <stdio.h>
#include <string.h>
#include <memory.h>
#include <stdlib.h>


struct node
{
    int value;
    struct node *next_ptr;
};


struct node *new_node(int value)
{
    struct node *node_ptr = malloc(sizeof(struct node));
    node_ptr->value = value;
    node_ptr->next_ptr = NULL;
    return node_ptr;
}

void stack_push(struct node **stack_ptr, int value)
{
    struct node *tmp_ptr = new_node(value);
    if(*stack_ptr != NULL)
    {
        tmp_ptr->next_ptr = *stack_ptr;
    }
    *stack_ptr = tmp_ptr;
}

int stack_pop(struct node **stack_ptr)
{
    if(*stack_ptr == NULL)
       return -1; // error

    struct node *tmp_ptr = *stack_ptr;    
    if(tmp_ptr->next_ptr != NULL)
        *stack_ptr = tmp_ptr->next_ptr;
        
    int value = tmp_ptr->value;
    free(tmp_ptr);

    return value;
}

int stack_size(struct node **stack_ptr)
{
    int i = 0;
    if(*stack_ptr == NULL)
        return i;

    i++;
    struct node *tmp_ptr = *stack_ptr;
    while(tmp_ptr->next_ptr != NULL)
    {
        tmp_ptr = tmp_ptr->next_ptr;
        i++;
    }
    return i;
}


int main()
{
    // setup stack
    struct node *stack_ptr = NULL;
    stack_push(&stack_ptr, 1);     
    stack_push(&stack_ptr, 2);
    stack_push(&stack_ptr, 3);
    stack_push(&stack_ptr, 4);
    
    // navigate
    int size = stack_size(&stack_ptr);
    printf("stack size = %d\n", size);
    for(int i=0; i<size; i++)
    {
        printf("%d\n", stack_pop(&stack_ptr));
    }

    return 0;
}


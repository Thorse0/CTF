#include<stdio.h>
#include<string.h>
#include<stdlib.h>
int main(){
    char arr[100];
    printf("This challenge was created by Thorse!!!\n");
    printf("Input password: ");
    scanf("%s", arr);
    if ((arr[0] & 0x40) != 0
        && (arr[9] & 0x4) != 0
        && (arr[21] & 0x2) == 0
        && (arr[23] & 0x40) == 0
        && (arr[19] & 0x8) != 0
        && (arr[28] & 0x2) != 0
        && (arr[5] & 0x10) == 0
        && (arr[20] & 0x2) != 0
        && (arr[13] & 0x40) != 0
        && (arr[9] & 0x40) != 0
        && (arr[26] & 0x80) == 0
        && (arr[8] & 0x20) != 0
        && (arr[20] & 0x20) == 0
        && (arr[27] & 0x10) != 0
        && (arr[33] & 0x40) != 0
        && (arr[0] & 0x10) != 0
        && (arr[34] & 0x10) != 0
        && (arr[34] & 0x8) == 0
        && (arr[1] & 0x1) == 0
        && (arr[2] & 0x20) != 0
        && (arr[30] & 0x2) != 0
        && (arr[28] & 0x4) == 0
        && (arr[4] & 0x40) != 0
        && (arr[31] & 0x80) == 0
        && (arr[26] & 0x4) == 0
        && (arr[31] & 0x40) != 0
        && (arr[21] & 0x4) != 0
        && (arr[16] & 0x1) != 0
        && (arr[10] & 0x40) == 0
        && (arr[3] & 0x1) == 0
        && (arr[20] & 0x10) != 0
        && (arr[10] & 0x80) == 0
        && (arr[10] & 0x4) != 0
        && (arr[35] & 0x10) != 0
        && (arr[0] & 0x2) == 0
        && (arr[29] & 0x80) == 0
        && (arr[15] & 0x20) != 0
        && (arr[36] & 0x20) != 0
        && (arr[32] & 0x8) == 0
        && (arr[3] & 0x4) == 0
        && (arr[22] & 0x8) != 0
        && (arr[30] & 0x80) == 0
        && (arr[16] & 0x20) != 0
        && (arr[2] & 0x8) != 0
        && (arr[30] & 0x10) != 0
        && (arr[33] & 0x80) == 0
        && (arr[8] & 0x80) == 0
        && (arr[28] & 0x20) != 0
        && (arr[12] & 0x1) != 0
        && (arr[5] & 0x1) != 0
        && (arr[0] & 0x20) == 0
        && (arr[24] & 0x10) != 0
        && (arr[9] & 0x1) == 0
        && (arr[5] & 0x20) != 0
        && (arr[20] & 0x4) != 0
        && (arr[34] & 0x1) == 0
        && (arr[27] & 0x8) != 0
        && (arr[33] & 0x20) != 0
        && (arr[18] & 0x1) == 0
        && (arr[27] & 0x4) != 0
        && (arr[32] & 0x40) != 0
        && (arr[19] & 0x2) == 0
        && (arr[32] & 0x20) != 0
        && (arr[17] & 0x1) == 0
        && (arr[33] & 0x10) == 0
        && (arr[3] & 0x20) != 0
        && (arr[0] & 0x4) != 0
        && (arr[26] & 0x1) != 0
        && (arr[32] & 0x2) != 0
        && (arr[29] & 0x8) == 0
        && (arr[28] & 0x8) == 0
        && (arr[2] & 0x4) != 0
        && (arr[6] & 0x8) != 0
        && (arr[29] & 0x1) == 0
        && (arr[30] & 0x8) != 0
        && (arr[13] & 0x2) != 0
        && (arr[0] & 0x80) == 0
        && (arr[15] & 0x10) == 0
        && (arr[16] & 0x4) != 0
        && (arr[10] & 0x10) != 0
        && (arr[24] & 0x8) == 0
        && (arr[17] & 0x20) != 0
        && (arr[24] & 0x1) == 0
        && (arr[12] & 0x10) == 0
        && (arr[14] & 0x20) == 0
        && (arr[25] & 0x10) == 0
        && (arr[3] & 0x40) != 0
        && (arr[6] & 0x20) != 0
        && (arr[12] & 0x4) == 0
        && (arr[16] & 0x80) == 0
        && (arr[23] & 0x4) != 0
        && (arr[14] & 0x2) == 0
        && (arr[15] & 0x4) != 0
        && (arr[0] & 0x1) == 0
        && (arr[32] & 0x1) == 0
        && (arr[27] & 0x20) == 0
        && (arr[22] & 0x40) != 0
        && (arr[14] & 0x10) == 0
        && (arr[11] & 0x8) == 0
        && (arr[35] & 0x40) != 0
        && (arr[8] & 0x2) == 0
        && (arr[24] & 0x80) == 0
        && (arr[7] & 0x40) == 0
        && (arr[25] & 0x4) != 0
        && (arr[11] & 0x2) != 0
        && (arr[4] & 0x2) != 0
        && (arr[17] & 0x8) == 0
        && (arr[20] & 0x80) == 0
        && (arr[31] & 0x4) != 0
        && (arr[34] & 0x20) != 0
        && (arr[21] & 0x1) == 0
        && (arr[16] & 0x2) == 0
        && (arr[18] & 0x80) == 0
        && (arr[10] & 0x1) == 0
        && (arr[6] & 0x1) != 0
        && (arr[36] & 0x4) != 0
        && (arr[13] & 0x8) != 0
        && (arr[18] & 0x20) != 0
        && (arr[19] & 0x1) != 0
        && (arr[5] & 0x8) == 0
        && (arr[18] & 0x10) != 0
        && (arr[36] & 0x8) != 0
        && (arr[7] & 0x80) == 0
        && (arr[23] & 0x1) == 0
        && (arr[16] & 0x10) == 0
        && (arr[7] & 0x10) != 0
        && (arr[33] & 0x8) == 0
        && (arr[5] & 0x80) == 0
        && (arr[7] & 0x2) == 0
        && (arr[28] & 0x80) == 0
        && (arr[8] & 0x8) == 0
        && (arr[7] & 0x4) != 0
        && (arr[21] & 0x80) == 0
        && (arr[13] & 0x10) != 0
        && (arr[5] & 0x4) != 0
        && (arr[2] & 0x40) != 0
        && (arr[29] & 0x10) != 0
        && (arr[33] & 0x2) == 0
        && (arr[17] & 0x10) != 0
        && (arr[3] & 0x10) != 0
        && (arr[27] & 0x2) != 0
        && (arr[20] & 0x1) != 0
        && (arr[19] & 0x40) != 0
        && (arr[15] & 0x8) == 0
        && (arr[25] & 0x8) == 0
        && (arr[26] & 0x40) != 0
        && (arr[8] & 0x40) != 0
        && (arr[29] & 0x4) == 0
        && (arr[5] & 0x2) == 0
        && (arr[22] & 0x1) == 0
        && (arr[12] & 0x80) == 0
        && (arr[12] & 0x40) != 0
        && (arr[3] & 0x80) == 0
        && (arr[27] & 0x40) != 0
        && (arr[2] & 0x1) != 0
        && (arr[12] & 0x20) != 0
        && (arr[19] & 0x10) != 0
        && (arr[29] & 0x2) == 0
        && (arr[15] & 0x40) != 0
        && (arr[14] & 0x8) != 0
        && (arr[13] & 0x1) != 0
        && (arr[17] & 0x4) == 0
        && (arr[23] & 0x10) != 0
        && (arr[21] & 0x20) == 0
        && (arr[1] & 0x10) == 0
        && (arr[30] & 0x1) != 0
        && (arr[24] & 0x40) != 0
        && (arr[13] & 0x4) != 0
        && (arr[31] & 0x10) == 0
        && (arr[35] & 0x1) == 0
        && (arr[36] & 0x40) != 0
        && (arr[30] & 0x40) != 0
        && (arr[22] & 0x2) == 0
        && (arr[10] & 0x8) == 0
        && (arr[1] & 0x80) == 0
        && (arr[31] & 0x1) != 0
        && (arr[3] & 0x8) == 0
        && (arr[11] & 0x20) == 0
        && (arr[29] & 0x40) == 0
        && (arr[22] & 0x10) == 0
        && (arr[36] & 0x10) != 0
        && (arr[6] & 0x10) != 0
        && (arr[1] & 0x20) != 0
        && (arr[8] & 0x10) != 0
        && (arr[36] & 0x2) == 0
        && (arr[36] & 0x1) != 0
        && (arr[30] & 0x4) != 0
        && (arr[0] & 0x8) == 0
        && (arr[21] & 0x40) != 0
        && (arr[24] & 0x2) == 0
        && (arr[11] & 0x4) == 0
        && (arr[10] & 0x2) == 0
        && (arr[17] & 0x40) == 0
        && (arr[36] & 0x80) == 0
        && (arr[6] & 0x4) == 0
        && (arr[25] & 0x80) == 0
        && (arr[34] & 0x2) == 0
        && (arr[23] & 0x2) == 0
        && (arr[19] & 0x80) == 0
        && (arr[7] & 0x8) == 0
        && (arr[28] & 0x1) != 0
        && (arr[18] & 0x8) == 0
        && (arr[26] & 0x20) != 0
        && (arr[14] & 0x80) == 0
        && (arr[16] & 0x8) != 0
        && (arr[6] & 0x40) != 0
        && (arr[20] & 0x8) != 0
        && (arr[19] & 0x4) == 0
        && (arr[27] & 0x1) != 0
        && (arr[10] & 0x20) != 0
        && (arr[1] & 0x8) != 0
        && (arr[1] & 0x2) == 0
        && (arr[30] & 0x20) == 0
        && (arr[16] & 0x40) != 0
        && (arr[8] & 0x1) == 0
        && (arr[18] & 0x40) != 0
        && (arr[32] & 0x80) == 0
        && (arr[34] & 0x80) == 0
        && (arr[25] & 0x2) != 0
        && (arr[25] & 0x1) != 0
        && (arr[26] & 0x2) != 0
        && (arr[14] & 0x40) != 0
        && (arr[2] & 0x80) == 0
        && (arr[31] & 0x8) == 0
        && (arr[17] & 0x80) == 0
        && (arr[13] & 0x20) == 0
        && (arr[6] & 0x2) != 0
        && (arr[12] & 0x2) != 0
        && (arr[32] & 0x10) != 0
        && (arr[4] & 0x20) != 0
        && (arr[31] & 0x20) != 0
        && (arr[35] & 0x8) == 0
        && (arr[18] & 0x2) != 0
        && (arr[2] & 0x2) != 0
        && (arr[9] & 0x2) == 0
        && (arr[22] & 0x20) != 0
        && (arr[3] & 0x2) != 0
        && (arr[23] & 0x80) == 0
        && (arr[33] & 0x1) != 0
        && (arr[9] & 0x20) != 0
        && (arr[35] & 0x2) == 0
        && (arr[7] & 0x1) == 0
        && (arr[24] & 0x4) != 0
        && (arr[22] & 0x80) == 0
        && (arr[17] & 0x2) == 0
        && (arr[5] & 0x40) != 0
        && (arr[24] & 0x20) != 0
        && (arr[11] & 0x80) == 0
        && (arr[28] & 0x40) != 0
        && (arr[35] & 0x4) != 0
        && (arr[14] & 0x1) != 0
        && (arr[23] & 0x8) == 0
        && (arr[28] & 0x10) != 0
        && (arr[2] & 0x10) == 0
        && (arr[15] & 0x1) != 0
        && (arr[11] & 0x40) != 0
        && (arr[11] & 0x10) == 0
        && (arr[33] & 0x4) != 0
        && (arr[8] & 0x4) != 0
        && (arr[7] & 0x20) != 0
        && (arr[26] & 0x10) != 0
        && (arr[20] & 0x40) != 0
        && (arr[21] & 0x10) != 0
        && (arr[6] & 0x80) == 0
        && (arr[1] & 0x40) != 0
        && (arr[35] & 0x80) == 0
        && (arr[21] & 0x8) == 0
        && (arr[27] & 0x80) == 0
        && (arr[25] & 0x40) == 0
        && (arr[34] & 0x4) != 0
        && (arr[4] & 0x10) != 0
        && (arr[14] & 0x4) != 0
        && (arr[31] & 0x2) != 0
        && (arr[29] & 0x20) != 0
        && (arr[12] & 0x8) != 0
        && (arr[18] & 0x4) == 0
        && (arr[9] & 0x8) == 0
        && (arr[11] & 0x1) != 0
        && (arr[9] & 0x10) != 0
        && (arr[1] & 0x4) == 0
        && (arr[25] & 0x20) != 0
        && (arr[9] & 0x80) == 0
        && (arr[15] & 0x2) == 0
        && (arr[19] & 0x20) != 0
        && (arr[23] & 0x20) != 0
        && (arr[35] & 0x20) != 0
        && (arr[26] & 0x8) == 0
        && (arr[4] & 0x1) != 0
        && (arr[4] & 0x80) == 0
        && (arr[4] & 0x8) == 0
        && (arr[22] & 0x4) == 0
        && (arr[32] & 0x4) == 0
        && (arr[4] & 0x4) == 0
        && (arr[13] & 0x80) == 0
        && (arr[34] & 0x40) == 0
        && (arr[15] & 0x80) == 0)
    {
        printf("Congratulations!!! This is my second challenge\n");
    }
    else{
        printf("Sorry this password is incorrect!!!\n");
    }
    system("pause");
}
// flag = "Thorse{4tt4Ck_Mem0ry_Th4t's_s0_gre4t}"
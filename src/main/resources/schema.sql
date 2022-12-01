CREATE TABLE GOODS(
    GOODS_NO    INT(11)         NOT NULL COMMENT '상품번호',
    GOODS_NM    VARCHAR(100)    DEFAULT NULL COMMENT '상품명',
    DESCRIPTION  VARCHAR(300)    COMMENT '상품설명',
    COM_ID      VARCHAR(20)     DEFAULT NULL COMMENT '업체아이디',
    REG_DM      DATETIME        DEFAULT NULL COMMENT '상품정보 최조등록일시',
    UPD_DM      DATETIME        DEFAULT NULL COMMENT '상품정보 수정일시',
    PRIMARY KEY (GOODS_NO)
);


CREATE TABLE COMPANY(
    NO          INT AUTO_INCREMENT,
    COM_ID      VARCHAR(20)     NOT NULL COMMENT '업체아이디',
    COM_TYPE    INT DEFAULT 1   NOT NULL COMMENT '업체구분(1:공급,2:입점)',
    PASSWD      VARCHAR(255)    NULL COMMENT '비밀번호',
    CEO         VARCHAR(25)     NULL COMMENT '대표자이름',
    COM_NM      VARCHAR(30)     NULL COMMENT '상호',
    BIZ_TYPE    VARCHAR(1)      NULL COMMENT '사업자구분(개인:P, 법인: C)',
    BIZ_NUM     VARCHAR(25)     NULL COMMENT '사업자등록번호',
    PAY_FEE     DECIMAL(10,2)   NULL COMMENT '수수료율(#.##%)',
    USE_YN      CHAR            NULL COMMENT '사용여부',
    REG_DM      DATETIME        NULL COMMENT '등록일시',
    UPD_DM      DATETIME        NULL COMMENT '수정일시',
    PRIMARY KEY(NO)
);

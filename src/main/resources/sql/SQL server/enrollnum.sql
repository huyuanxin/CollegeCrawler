/*
 Navicat Premium Data Transfer

 Source Server         : SqlServer
 Source Server Type    : SQL Server
 Source Server Version : 10501600
 Source Host           : DESKTOP-CQCCQN5\SQLEXPRESS:1433
 Source Catalog        : huyuanxin
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 10501600
 File Encoding         : 65001

 Date: 19/03/2021 13:14:02
*/


-- ----------------------------
-- Table structure for enrollnum
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[enrollnum]') AND type IN ('U'))
	DROP TABLE [dbo].[enrollnum]
GO

CREATE TABLE [dbo].[enrollnum] (
  [id] bigint identity(1,1) NOT NULL,
  [college_name] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [num] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [year] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [province] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [curriculum] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [batch] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [type] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[enrollnum] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Primary Key structure for table enrollnum
-- ----------------------------
ALTER TABLE [dbo].[enrollnum] ADD CONSTRAINT [PK__enrollnu__3213E83F30E33A54] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


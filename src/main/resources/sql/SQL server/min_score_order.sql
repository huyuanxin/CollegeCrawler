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

 Date: 19/03/2021 11:34:28
*/


-- ----------------------------
-- Table structure for min_score_order
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[min_score_order]') AND type IN ('U'))
	DROP TABLE [dbo].[min_score_order]
GO

CREATE TABLE [dbo].[min_score_order] (
  [id] bigint NOT NULL,
  [college_name] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [rank] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [year] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [province] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [curriculum] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [batch] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [type] nvarchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[min_score_order] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Primary Key structure for table min_score_order
-- ----------------------------
ALTER TABLE [dbo].[min_score_order] ADD CONSTRAINT [PK__min_scor__3213E83F0504B816] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


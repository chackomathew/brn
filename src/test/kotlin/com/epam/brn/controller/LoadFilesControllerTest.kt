package com.epam.brn.controller

import com.epam.brn.service.ExerciseService
import com.epam.brn.service.StudyHistoryService
import com.epam.brn.service.UserAccountService
import com.epam.brn.upload.CsvUploadService
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.mock.web.MockMultipartFile
import java.io.File
import java.io.FileInputStream

@ExtendWith(MockitoExtension::class)
internal class LoadFilesControllerTest {

    @InjectMocks
    lateinit var adminController: AdminController

    @Mock
    lateinit var csvUploadService: CsvUploadService

    @Mock
    lateinit var studyHistoryService: StudyHistoryService

    @Mock
    lateinit var userAccountService: UserAccountService

    @Mock
    lateinit var exerciseService: ExerciseService

    @Test
    fun `should call upload service to load file for 1 series`() {
        // GIVEN
        val taskFile = MockMultipartFile(
            "series_words.csv",
            FileInputStream("src${File.separator}test${File.separator}resources${File.separator}inputData${File.separator}tasks${File.separator}series_words.csv")
        )
        // WHEN
        adminController.loadExercises(1, taskFile)
        // THEN
        verify(csvUploadService, times(1)).loadExercises(1, taskFile)
    }
}
